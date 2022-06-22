package com.nttdata.bc19.mstransactiondebitcard.service.impl;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardPerson;
import com.nttdata.bc19.mstransactiondebitcard.repository.ITransactionDebitCardPersonRepository;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardPersonRequest;
import com.nttdata.bc19.mstransactiondebitcard.service.ITransactionDebitCardPersonService;
import com.nttdata.bc19.mstransactiondebitcard.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionDebitCardPersonServiceImpl implements ITransactionDebitCardPersonService {

    @Autowired
    ITransactionDebitCardPersonRepository transactionDebitCardPersonRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionDebitCardPerson> create(TransactionDebitCardPersonRequest transactionDebitCardPersonRequest) {
        return null;
    }

    @Override
    public Mono<TransactionDebitCardPerson> update(TransactionDebitCardPerson transactionDebitCardPerson) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionDebitCardPersonRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionDebitCardPerson> findById(String id) {
        return transactionDebitCardPersonRepository.findById(id);
    }

    @Override
    public Flux<TransactionDebitCardPerson> findAll() {
        return transactionDebitCardPersonRepository.findAll();
    }

    @Override
    public Flux<TransactionDebitCardPerson> findByIdDebitCardPerson(String idCreditCardPerson) {
        return transactionDebitCardPersonRepository.findByIdDebitCardPerson(idCreditCardPerson);
    }
}
