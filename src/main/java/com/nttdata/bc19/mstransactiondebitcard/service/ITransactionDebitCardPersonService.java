package com.nttdata.bc19.mstransactiondebitcard.service;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardPerson;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardPersonRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionDebitCardPersonService {

    Mono<TransactionDebitCardPerson> create(TransactionDebitCardPersonRequest transactionDebitCardPersonRequest);
    Mono<TransactionDebitCardPerson> update(TransactionDebitCardPerson transactionDebitCardPerson);
    Mono<Void>deleteById(String id);
    Mono<TransactionDebitCardPerson> findById(String id);
    Flux<TransactionDebitCardPerson> findAll();

    Flux<TransactionDebitCardPerson> findByIdDebitCardPerson(String idDebitCardPerson);
}
