package com.nttdatabc.msbootcoin.utils.validation;

import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
import com.nttdatabc.msbootcoin.model.UserBootcoin;
import com.nttdatabc.msbootcoin.model.enums.TypeModeCharged;
import com.nttdatabc.msbootcoin.model.enums.TypeModePayment;
import com.nttdatabc.msbootcoin.model.enums.TypeValidationBank;
import com.nttdatabc.msbootcoin.repository.TransactionBootcoinRepository;
import com.nttdatabc.msbootcoin.service.UserBootcoinServiceImpl;
import com.nttdatabc.msbootcoin.utils.exceptions.errors.ErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.nttdatabc.msbootcoin.utils.Constantes.*;

@Component
public class TransactionBootcoinValidation {
  public Mono<Void> validateCentralInsert(TransactionBootcoin transactionBootcoin, UserBootcoinServiceImpl userBootcoinService){
    return validateTransactionNoNulls(transactionBootcoin)
        .then(validateTransactionEmpty(transactionBootcoin))
        .then(verifyTypeModePayment(transactionBootcoin))
        .then(validateExistsUser(transactionBootcoin.getIdUserBuy(), userBootcoinService))
        .then();
  }
  public Mono<TransactionBootcoin> validateCentralAcceptExchange(TransactionBootcoin transactionBootcoin, UserBootcoinServiceImpl userBootcoinService, TransactionBootcoinRepository transactionBootcoinRepository){
    return validateAcceptExchangenNoNulls(transactionBootcoin)
        .then(validateAcceptExchangeEmpty(transactionBootcoin))
        .then(validateHasBootcoinRequired(transactionBootcoin,userBootcoinService,transactionBootcoinRepository))
        .then(verifyTypeModeCharged(transactionBootcoin))
        .then(validateExistsUser(transactionBootcoin.getIdUserSeller(), userBootcoinService))
        .then(validateCompleted(transactionBootcoin.getId(), transactionBootcoinRepository))
        .then(validateExistTransaction(transactionBootcoin.getId(), transactionBootcoinRepository));

  }


  private Mono<Void> validateTransactionNoNulls(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> c.getIdUserBuy() != null)
        .filter(c -> c.getMountBuy() != null)
        .filter(c -> c.getModePayment() != null)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_REQUEST,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> validateTransactionEmpty(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> !c.getIdUserBuy().isEmpty())
        .filter(c -> !c.getMountBuy().toString().isBlank())
        .filter(c -> !c.getModePayment().isBlank())
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_VALUE_EMPTY,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> verifyTypeModePayment(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> {
          String typeAccount = c.getModePayment();
          return typeAccount.equalsIgnoreCase(TypeModePayment.YANKI.toString())
              || typeAccount.equalsIgnoreCase(TypeModePayment.TRANSFERENCIA.toString());
        })
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_TYPE_MODE_PAYMENT,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<UserBootcoin>validateExistsUser(String userId, UserBootcoinServiceImpl userBootcoinService){
    return userBootcoinService.getUserBootcoinByNumberPhone(userId);
  }

  private Mono<Void> validateAcceptExchangenNoNulls(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> c.getId() != null)
        .filter(c -> c.getIdUserSeller() != null)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_REQUEST,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> validateAcceptExchangeEmpty(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> !c.getId().isEmpty())
        .filter(c -> !c.getIdUserSeller().isBlank())
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_VALUE_EMPTY,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }

  private Mono<TransactionBootcoin>validateExistTransaction(String idTransaction, TransactionBootcoinRepository transactionBootcoinRepository){
    return transactionBootcoinRepository.findById(idTransaction)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_NOT_FOUND_RECURSO, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND)));
  }

  private Mono<Void> verifyTypeModeCharged(TransactionBootcoin transactionBootcoin) {
    return Mono.just(transactionBootcoin)
        .filter(c -> {
          String typeAccount = c.getModeCharged();
          return typeAccount.equalsIgnoreCase(TypeModeCharged.YANKI.toString())
              || typeAccount.equalsIgnoreCase(TypeModeCharged.CORRIENTE.toString())
              || typeAccount.equalsIgnoreCase(TypeModeCharged.AHORRO.toString());
        })
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_TYPE_MODE_CHARGED,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }

  private Mono<Void>validateHasBootcoinRequired(TransactionBootcoin transactionBootcoin, UserBootcoinServiceImpl userBootcoinService, TransactionBootcoinRepository transactionBootcoinRepository){
    return transactionBootcoinRepository.findById(transactionBootcoin.getId())
        .flatMap(transactionBootcoinFlujo -> userBootcoinService.getUserBootcoinByNumberPhone(transactionBootcoin.getIdUserSeller())
            .flatMap(userBootcoin -> {
              if(transactionBootcoinFlujo.getMountBuy().doubleValue() > userBootcoin.getBalanceBootcoin().doubleValue()){
                return Mono.error(new ErrorResponseException(EX_ERROR_BOOTCOIN_INSUFICIENT, HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT));
              }else{
                return Mono.empty();
              }
            }));
  }
  private Mono<Void>validateCompleted(String idTransaction, TransactionBootcoinRepository transactionBootcoinRepository){
    return transactionBootcoinRepository.findById(idTransaction)
        .flatMap(transactionBootcoin -> {
         if(transactionBootcoin.getValidateBank()!=null){
           if(transactionBootcoin.getValidateBank().equalsIgnoreCase(TypeValidationBank.INPROGRESS.toString())){
             return Mono.empty();
           }else{
             return Mono.error(new ErrorResponseException(EX_ERROR_TRANSACTION_COMPLETED, HttpStatus.CONFLICT.value(),HttpStatus.CONFLICT ));
           }
         }else{
           return Mono.empty();
         }
        });
  }

}
