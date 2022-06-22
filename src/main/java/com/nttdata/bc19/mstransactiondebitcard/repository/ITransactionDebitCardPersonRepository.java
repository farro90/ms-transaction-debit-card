package com.nttdata.bc19.mstransactiondebitcard.repository;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardPerson;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionDebitCardPersonRepository extends ReactiveMongoRepository<TransactionDebitCardPerson, String> {

    Flux<TransactionDebitCardPerson> findByIdDebitCardPerson(String idDebitCardPerson);
}
