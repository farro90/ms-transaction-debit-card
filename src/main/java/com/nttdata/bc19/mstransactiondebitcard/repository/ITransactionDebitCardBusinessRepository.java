package com.nttdata.bc19.mstransactiondebitcard.repository;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardBusiness;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionDebitCardBusinessRepository extends ReactiveMongoRepository<TransactionDebitCardBusiness, String> {

    Flux<TransactionDebitCardBusiness> findByIdDebitCardBusiness(String idDebitCardBusiness);
}
