package com.nttdatabc.msbootcoin.service.interfaces;

import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionBootcoinService {
  Mono<Void>createTransactionService(TransactionBootcoin transactionBootcoin);
  Mono<Void>accepetExchangeTransactionService(TransactionBootcoin transactionBootcoin);
  Flux<TransactionBootcoin>getAllTransactionService();
  Mono<TransactionBootcoin>getTransactionByIdService(String id);
}
