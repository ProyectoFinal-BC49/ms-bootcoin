package com.nttdatabc.msbootcoin.repository;

import com.nttdatabc.msbootcoin.model.Rate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Repository
public interface RateRepository extends ReactiveMongoRepository<Rate, String> {
  Mono<Rate>findTop1ByOrderByLocalDateTimeDesc();
}
