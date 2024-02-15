package com.nttdatabc.msbootcoin.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
import com.nttdatabc.msbootcoin.model.enums.TypeModePayment;
import com.nttdatabc.msbootcoin.model.enums.TypeValidationBank;
import com.nttdatabc.msbootcoin.repository.TransactionBootcoinRepository;
import com.nttdatabc.msbootcoin.repository.UserBootcoinRepository;
import com.nttdatabc.msbootcoin.service.interfaces.TransactionBootcoinService;
import com.nttdatabc.msbootcoin.utils.Utilitarios;
import com.nttdatabc.msbootcoin.utils.exceptions.errors.ErrorResponseException;
import com.nttdatabc.msbootcoin.utils.validation.TransactionBootcoinValidation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;

import static com.nttdatabc.msbootcoin.utils.Utilitarios.generateUuid;

@Service
public class TransactionBootcoinServiceImpl implements TransactionBootcoinService {
  @Autowired
  private TransactionBootcoinRepository transactionBootcoinRepository;
  @Autowired
  private TransactionBootcoinValidation transactionBootcoinValidation;
  @Autowired
  private UserBootcoinServiceImpl userBootcoinService;
  @Autowired
  private RateServiceImpl rateService;
  @Autowired
  private KafkaTemplate<String, String>kafkaTemplate;
  @Autowired
  private UserBootcoinRepository userBootcoinRepository;
  
  @Override
  public Mono<Void> createTransactionService(TransactionBootcoin transactionBootcoin) {
    return transactionBootcoinValidation.validateCentralInsert(transactionBootcoin, userBootcoinService)
        .then(Mono.just(transactionBootcoin))
        .flatMap(transactionFlujo -> rateService.getRateService()
            .flatMap(rate -> {
              transactionFlujo.setId(generateUuid());
              transactionFlujo.setMountSolesCalculated(transactionFlujo.getMountBuy().multiply(rate.getRateBootcoin()));
              return transactionBootcoinRepository.save(transactionFlujo);
            })).then();
  }

  @Override
  public Mono<Void> accepetExchangeTransactionService(TransactionBootcoin transactionBootcoin) {
    return transactionBootcoinValidation.validateCentralAcceptExchange(transactionBootcoin,userBootcoinService,transactionBootcoinRepository)
        .flatMap(transactionFlujo -> {
          transactionFlujo.setIdUserSeller(transactionBootcoin.getIdUserSeller());
          transactionFlujo.setNumberTransaction(generateUuid());
          transactionFlujo.setValidateBank(TypeValidationBank.INPROGRESS.toString());
          transactionFlujo.setModeCharged(transactionBootcoin.getModeCharged());
          return transactionBootcoinRepository.save(transactionFlujo);
        }).flatMap(transactionBootcoinFlujo -> {
          Gson gson = new Gson();
          String transactionValidate = gson.toJson(transactionBootcoinFlujo);
          if(transactionBootcoinFlujo.getModePayment().equalsIgnoreCase(TypeModePayment.YANKI.toString())){
            kafkaTemplate.send("verify-modepayment-yanki-bootcoin", transactionValidate);
            return Mono.empty();
          }else{
            return Mono.empty();
          }
        }).then();
  }

  @Override
  public Flux<TransactionBootcoin> getAllTransactionService() {
    return transactionBootcoinRepository.findAll();
  }

  @Override
  public Mono<TransactionBootcoin> getTransactionByIdService(String id) {
    return transactionBootcoinRepository.findById(id)
        .switchIfEmpty(Mono.error(new ErrorResponseException("", HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND)));
  }

  @KafkaListener(topics = {"validation-transaction-error"}, groupId = "my-group-id")
  private void validationError(String message){
    Gson gson = new Gson();
    Map<String, String> map = gson.fromJson(message, new TypeToken<Map<String, String>>() {
    }.getType());
    String id = map.get("id");
    String reasonRejection = map.get("reasonRejection");

    getTransactionByIdService(id).flatMap(transactionBootcoin -> {
      transactionBootcoin.setValidateBank(TypeValidationBank.REJECT.toString());
      transactionBootcoin.setReasonRejection(reasonRejection);
      return transactionBootcoinRepository.save(transactionBootcoin);
    }).subscribe();
  }
  @KafkaListener(topics = {"validation-transaction-success"}, groupId = "my-group-id")
  private void validationSuccess(String message){
    Gson gson = new Gson();
    Map<String, String> map = gson.fromJson(message, new TypeToken<Map<String, String>>() {
    }.getType());
    String idUserBuy = map.get("idUserBuy");
    String idUserSeller = map.get("idUserSeller");
    String id = map.get("id");
    double mountBuy = Double.parseDouble(map.get("mountBuy"));

    getTransactionByIdService(id).flatMap(transactionBootcoin -> {
      transactionBootcoin.setValidateBank(TypeValidationBank.ACCEPT.toString());
      return transactionBootcoinRepository.save(transactionBootcoin);
    }).subscribe();


    userBootcoinService.getUserBootcoinByNumberPhone(idUserBuy)
        .flatMap(userBootcoin -> {
          userBootcoin.setBalanceBootcoin(userBootcoin.getBalanceBootcoin().add(BigDecimal.valueOf(mountBuy)));
          return userBootcoinRepository.save(userBootcoin);
        }).subscribe();

    userBootcoinService.getUserBootcoinByNumberPhone(idUserSeller)
        .flatMap(userBootcoin -> {
          userBootcoin.setBalanceBootcoin(userBootcoin.getBalanceBootcoin().subtract(BigDecimal.valueOf(mountBuy)));
          return userBootcoinRepository.save(userBootcoin);
        }).subscribe();

    kafkaTemplate.send("effect-transaction", message);
  }
}
