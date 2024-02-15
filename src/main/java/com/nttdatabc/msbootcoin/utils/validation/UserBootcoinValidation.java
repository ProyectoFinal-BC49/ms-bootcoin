package com.nttdatabc.msbootcoin.utils.validation;

import com.nttdatabc.msbootcoin.model.UserBootcoin;
import com.nttdatabc.msbootcoin.model.enums.TypeIdentification;
import com.nttdatabc.msbootcoin.repository.UserBootcoinRepository;
import com.nttdatabc.msbootcoin.utils.exceptions.errors.ErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.nttdatabc.msbootcoin.utils.Constantes.*;

@Component
public class UserBootcoinValidation {

  public Mono<Void>validateCentralInsert(UserBootcoin userBootcoin, UserBootcoinRepository userBootcoinRepository){
    return validateUserNoNulls(userBootcoin)
        .then(validateUserEmpty(userBootcoin))
        .then(verifyTypeAccount(userBootcoin))
        .then(verifyDataDuplicatedNumberPhone(userBootcoin, userBootcoinRepository))
        .then(verifyDataDuplicatedNumberIdentification(userBootcoin, userBootcoinRepository));
  }
  private Mono<Void> validateUserNoNulls(UserBootcoin userBootcoin) {
    return Mono.just(userBootcoin)
        .filter(c -> c.getEmail() != null)
        .filter(c -> c.getNumberIdentification() != null)
        .filter(c -> c.getNumberPhone() != null)
        .filter(c -> c.getTypeIdentification() != null)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_REQUEST,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> validateUserEmpty(UserBootcoin userBootcoin) {
    return Mono.just(userBootcoin)
        .filter(c -> !c.getEmail().isEmpty())
        .filter(c -> !c.getNumberIdentification().isBlank())
        .filter(c -> !c.getNumberPhone().isBlank())
        .filter(c -> !c.getTypeIdentification().isBlank())
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_VALUE_EMPTY,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> verifyTypeAccount(UserBootcoin userBootcoin) {
    return Mono.just(userBootcoin)
        .filter(c -> {
          String typeAccount = c.getTypeIdentification();
          return typeAccount.equalsIgnoreCase(TypeIdentification.DNI.toString())
              || typeAccount.equalsIgnoreCase(TypeIdentification.CEX.toString())
              || typeAccount.equalsIgnoreCase(TypeIdentification.PASAPORTE.toString());
        })
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_TYPE_DOCUMENT,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private Mono<Void> verifyDataDuplicatedNumberPhone(UserBootcoin userBootcoin, UserBootcoinRepository userBootcoinRepository) {
    return userBootcoinRepository.findByNumberPhone(userBootcoin.getNumberPhone())
        .hasElement()
        .flatMap(aBoolean -> {
          if (aBoolean) {
            return Mono.error(new ErrorResponseException(EX_ERROR_PHONE_NUMBER_DUPLICATE,
                HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT));
          } else {
            return Mono.empty();
          }
        });
  }
  private Mono<Void> verifyDataDuplicatedNumberIdentification(UserBootcoin userBootcoin, UserBootcoinRepository userBootcoinRepository) {
    return userBootcoinRepository.findByNumberIdentification(userBootcoin.getNumberIdentification())
        .hasElement()
        .flatMap(aBoolean -> {
          if (aBoolean) {
            return Mono.error(new ErrorResponseException(EX_ERROR_PHONE_NUMBER_DUPLICATE,
                HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT));
          } else {
            return Mono.empty();
          }
        });
  }
}
