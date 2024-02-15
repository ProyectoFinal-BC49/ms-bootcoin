package com.nttdatabc.msbootcoin.controller;

import com.nttdatabc.msbootcoin.controller.interfaces.TransactionBootcoinControllerApi;
import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
import com.nttdatabc.msbootcoin.service.TransactionBootcoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.nttdatabc.msbootcoin.utils.Constantes.PREFIX_PATH;

@RestController
@Slf4j
@RequestMapping(PREFIX_PATH)
public class TransactionBootcoinController implements TransactionBootcoinControllerApi {
  @Autowired
  private TransactionBootcoinServiceImpl transactionBootcoinService;
  @Override
  public ResponseEntity<Mono<Void>> accepetExchangeTransaction(TransactionBootcoin transactionBootcoin, ServerWebExchange exchange) {
    return new ResponseEntity<>(transactionBootcoinService.accepetExchangeTransactionService(transactionBootcoin)
        .doOnSubscribe(unused -> log.info("accepetExchangeTransaction:: iniciando"))
        .doOnError(throwable -> log.error("accepetExchangeTransaction:: error " + throwable.getMessage()))
        .doOnSuccess(ignored -> log.info("accepetExchangeTransaction:: finalizado con exito")), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Mono<Void>> createTransaction(TransactionBootcoin transactionBootcoin, ServerWebExchange exchange) {
    return new ResponseEntity<>(transactionBootcoinService.createTransactionService(transactionBootcoin)
        .doOnSubscribe(unused -> log.info("createTransaction:: iniciando"))
        .doOnError(throwable -> log.error("createTransaction:: error " + throwable.getMessage()))
        .doOnSuccess(ignored -> log.info("createTransaction:: finalizado con exito")), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Flux<TransactionBootcoin>> getAllTransaction(ServerWebExchange exchange) {
    return ResponseEntity.ok(
        transactionBootcoinService.getAllTransactionService()
            .doOnSubscribe(unused -> log.info("getAllTransaction:: iniciando"))
            .doOnError(throwable -> log.error("getAllTransaction:: error " + throwable.getMessage()))
            .doOnComplete(() -> log.info("getAllTransaction:: completadoo"))
    );
  }
}
