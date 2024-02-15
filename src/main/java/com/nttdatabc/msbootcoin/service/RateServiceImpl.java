package com.nttdatabc.msbootcoin.service;

import com.nttdatabc.msbootcoin.model.Rate;
import com.nttdatabc.msbootcoin.repository.RateRepository;
import com.nttdatabc.msbootcoin.service.interfaces.RateService;
import com.nttdatabc.msbootcoin.utils.validation.RateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class RateServiceImpl implements RateService {
  @Autowired
  private RateRepository rateRepository;
  @Autowired
  private RateValidation rateValidation;
  @Override
  public Mono<Void> createRateService(Rate rate) {

    return rateValidation.validateRateCentralFacade(rate)
        .then(Mono.just(rate))
        .flatMap(rateFlujo -> {
          rateFlujo.setLocalDateTime(LocalDateTime.now());
          return rateRepository.save(rateFlujo);
        }).then();

  }

  @Override
  public Mono<Rate> getRateService() {
    return rateRepository.findTop1ByOrderByLocalDateTimeDesc();
  }
}
