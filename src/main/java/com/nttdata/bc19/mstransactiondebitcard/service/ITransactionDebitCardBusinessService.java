package com.nttdata.bc19.mstransactiondebitcard.service;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardBusiness;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardBusinessRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionDebitCardBusinessService {

    Mono<TransactionDebitCardBusiness> create(TransactionDebitCardBusinessRequest transactionCreditCardBusinessRequest);
    Mono<TransactionDebitCardBusiness> update(TransactionDebitCardBusiness transactionCreditCardBusiness);
    Mono<Void>deleteById(String id);
    Mono<TransactionDebitCardBusiness> findById(String id);
    Flux<TransactionDebitCardBusiness> findAll();

    Flux<TransactionDebitCardBusiness> findByIdDebitCardBusiness(String idDebitCardBusiness);
}
