package com.nttdatabc.msbootcoin.service.interfaces;

import com.nttdatabc.msbootcoin.model.UserBootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserBootcoinService {
  Mono<Void> createUserBootcoinService(UserBootcoin userBootcoin);
  Flux<UserBootcoin>getAllUserBootcoinService();
  Mono<UserBootcoin>getUserBootcoinByIdService(String userId);

  Mono<Void>updateUserBootcoinService(UserBootcoin userBootcoin);

  Mono<UserBootcoin>getUserBootcoinByNumberPhone(String numberPhone);

}
