package com.nttdatabc.msbootcoin.utils.validation;

import com.nttdatabc.msbootcoin.model.Rate;
import com.nttdatabc.msbootcoin.utils.exceptions.errors.ErrorResponseException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.nttdatabc.msbootcoin.utils.Constantes.*;

@Component
public class RateValidation {

  public Mono<Void>validateRateCentralFacade(Rate rate){
    return validateRateNoNulls(rate)
        .then(validateRateEmpty(rate))
        .then(verifyValues(rate));
  }

  private Mono<Void>validateRateNoNulls(Rate rate){
    return Mono.just(rate)
        .filter(c -> c.getRateBootcoin() != null)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_REQUEST,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private  Mono<Void> validateRateEmpty(Rate rate) {
    return Mono.just(rate)
        .filter(c -> !c.getRateBootcoin().toString().isEmpty())
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_VALUE_EMPTY,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
  private  Mono<Void> verifyValues(Rate rate) {
    return Mono.just(rate)
        .filter(c -> c.getRateBootcoin().doubleValue() > VALUE_MIN_ACCOUNT_BANK)
        .switchIfEmpty(Mono.error(new ErrorResponseException(EX_ERROR_VALUE_MIN,
            HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST)))
        .then();
  }
}
