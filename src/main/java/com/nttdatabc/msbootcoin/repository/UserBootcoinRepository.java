package com.nttdatabc.msbootcoin.repository;

import com.nttdatabc.msbootcoin.model.UserBootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserBootcoinRepository extends ReactiveMongoRepository<UserBootcoin,String> {
  Mono<UserBootcoin>findByNumberPhone(String numberPhone);
  Mono<UserBootcoin>findByNumberIdentification(String numberPhone);
}
