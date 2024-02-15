package com.nttdatabc.msbootcoin.service;

import com.nttdatabc.msbootcoin.model.UserBootcoin;
import com.nttdatabc.msbootcoin.repository.UserBootcoinRepository;
import com.nttdatabc.msbootcoin.service.interfaces.UserBootcoinService;
import com.nttdatabc.msbootcoin.utils.exceptions.errors.ErrorResponseException;
import com.nttdatabc.msbootcoin.utils.validation.UserBootcoinValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static com.nttdatabc.msbootcoin.utils.Constantes.EX_NOT_FOUND_RECURSO;
import static com.nttdatabc.msbootcoin.utils.Constantes.VALUE_INIT_CREATE_BOOTCOIN;
import static com.nttdatabc.msbootcoin.utils.Utilitarios.generateUuid;

@Service
public class UserBootcoinServiceImpl implements UserBootcoinService {

  @Autowired
  private UserBootcoinRepository userBootcoinRepository;
  @Autowired
  private UserBootcoinValidation userBootcoinValidation;

  @Override
  public Mono<Void> createUserBootcoinService(UserBootcoin userBootcoin) {
    return userBootcoinValidation.validateCentralInsert(userBootcoin, userBootcoinRepository)
        .then(Mono.just(userBootcoin))
        .flatMap(userBootcoinFlujo -> {
          userBootcoinFlujo.setId(generateUuid());
          userBootcoinFlujo.setBalanceBootcoin(BigDecimal.valueOf(VALUE_INIT_CREATE_BOOTCOIN));
          return userBootcoinRepository.save(userBootcoinFlujo);
        }).then();
  }

  @Override
  public Flux<UserBootcoin> getAllUserBootcoinService() {
    return userBootcoinRepository.findAll();
  }

  @Override
  public Mono<UserBootcoin> getUserBootcoinByIdService(String userId) {
    return userBootcoinRepository.findById(userId)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_NOT_FOUND_RECURSO,
            HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND )));
  }

  @Override
  public Mono<Void> updateUserBootcoinService(UserBootcoin userBootcoin) {
    return getUserBootcoinByIdService(userBootcoin.getId())
        .flatMap(userBootcoinFlujo -> {
          userBootcoinFlujo.setBalanceBootcoin(userBootcoin.getBalanceBootcoin());
          return userBootcoinRepository.save(userBootcoinFlujo);
        }).then();
  }

  @Override
  public Mono<UserBootcoin> getUserBootcoinByNumberPhone(String numberPhone) {
    return userBootcoinRepository.findByNumberPhone(numberPhone)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_NOT_FOUND_RECURSO,
            HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND )));
  }
}
