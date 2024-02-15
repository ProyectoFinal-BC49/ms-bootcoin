package com.nttdatabc.msbootcoin.controller;

import com.nttdatabc.msbootcoin.controller.interfaces.UserBootcoinControllerApi;
import com.nttdatabc.msbootcoin.model.UserBootcoin;
import com.nttdatabc.msbootcoin.service.UserBootcoinServiceImpl;
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
public class UserBootcoinController implements UserBootcoinControllerApi {
  @Autowired
  private UserBootcoinServiceImpl userBootcoinService;
  @Override
  public ResponseEntity<Mono<Void>> createUserBootcoin(UserBootcoin userBootcoin, ServerWebExchange exchange) {
    return new ResponseEntity<>(userBootcoinService.createUserBootcoinService(userBootcoin)
        .doOnSubscribe(unused -> log.info("createUserBootcoin:: iniciando"))
        .doOnError(throwable -> log.error("createUserBootcoin:: error " + throwable.getMessage()))
        .doOnSuccess(ignored -> log.info("createUserBootcoin:: finalizado con exito")), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Flux<UserBootcoin>> getAllUserBootcoin(ServerWebExchange exchange) {
    return ResponseEntity.ok(
        userBootcoinService.getAllUserBootcoinService()
            .doOnSubscribe(unused -> log.info("getAllUserBootcoin:: iniciando"))
            .doOnError(throwable -> log.error("getAllUserBootcoin:: error " + throwable.getMessage()))
            .doOnComplete(() -> log.info("getAllUserBootcoin:: completadoo"))
    );
  }

  @Override
  public ResponseEntity<Mono<UserBootcoin>> getUserBootcoinById(String userId, ServerWebExchange exchange) {
    return ResponseEntity.ok(
        userBootcoinService.getUserBootcoinByIdService(userId)
            .doOnSubscribe(unused -> log.info("getUserBootcoinById:: iniciando"))
            .doOnError(throwable -> log.error("getUserBootcoinById:: error " + throwable.getMessage()))
            .doOnSuccess((d) -> log.info("getUserBootcoinById:: completadoo"))
    );
  }

  @Override
  public ResponseEntity<Mono<Void>> updateUserBootcoin(UserBootcoin userBootcoin, ServerWebExchange exchange) {
    return new ResponseEntity<>(userBootcoinService.updateUserBootcoinService(userBootcoin)
        .doOnSubscribe(unused -> log.info("updateUserBootcoin:: iniciando"))
        .doOnError(throwable -> log.error("updateUserBootcoin:: error " + throwable.getMessage()))
        .doOnSuccess(ignored -> log.info("updateUserBootcoin:: finalizado con exito")), HttpStatus.OK);
  }
}
