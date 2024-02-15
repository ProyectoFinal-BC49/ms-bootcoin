package com.nttdatabc.msbootcoin.repository;

import com.nttdatabc.msbootcoin.model.TransactionBootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBootcoinRepository extends ReactiveMongoRepository<TransactionBootcoin,String> {
}
