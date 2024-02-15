package com.nttdatabc.msbootcoin.controller;

import com.nttdatabc.msbootcoin.controller.interfaces.RateControllerApi;
import com.nttdatabc.msbootcoin.model.Rate;
import com.nttdatabc.msbootcoin.service.RateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static com.nttdatabc.msbootcoin.utils.Constantes.PREFIX_PATH;

@RestController
@Slf4j
@RequestMapping(PREFIX_PATH)
public class RateController implements RateControllerApi {
  @Autowired
  private RateServiceImpl rateService;
  @Override
  public ResponseEntity<Mono<Void>> createRate(Rate rate, ServerWebExchange exchange) {
    return new ResponseEntity<>(rateService.createRateService(rate)
        .doOnSubscribe(unused -> log.info("createRate:: iniciando"))
        .doOnError(throwable -> log.error("createRate:: error " + throwable.getMessage()))
        .doOnSuccess(ignored -> log.info("createRate:: finalizado con exito")), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Mono<Rate>> getRate(ServerWebExchange exchange) {
    return ResponseEntity.ok(
        rateService.getRateService()
            .doOnSubscribe(unused -> log.info("getRate:: iniciando"))
            .doOnError(throwable -> log.error("getRate:: error " + throwable.getMessage()))
            .doOnSuccess((e) -> log.info("getRate:: completadoo")));
  }
}
