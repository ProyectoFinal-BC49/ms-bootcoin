package com.nttdatabc.msbootcoin.service.interfaces;

import com.nttdatabc.msbootcoin.model.Rate;
import reactor.core.publisher.Mono;

public interface RateService {
  Mono<Void>createRateService(Rate rate);
  Mono<Rate>getRateService();
}
