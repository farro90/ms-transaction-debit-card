package com.nttdata.bc19.mstransactiondebitcard.service.impl;

import com.nttdata.bc19.mstransactiondebitcard.exception.ModelNotFoundException;
import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardBusiness;
import com.nttdata.bc19.mstransactiondebitcard.model.responseWC.Account;
import com.nttdata.bc19.mstransactiondebitcard.model.responseWC.DebitCardBusiness;
import com.nttdata.bc19.mstransactiondebitcard.repository.ITransactionDebitCardBusinessRepository;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardBusinessRequest;
import com.nttdata.bc19.mstransactiondebitcard.service.ITransactionDebitCardBusinessService;
import com.nttdata.bc19.mstransactiondebitcard.util.LogMessage;
import com.nttdata.bc19.mstransactiondebitcard.util.TransactionTypePasPro;
import com.nttdata.bc19.mstransactiondebitcard.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class TransactionDebitCardBusinessServiceImpl implements ITransactionDebitCardBusinessService {

    @Autowired
    ITransactionDebitCardBusinessRepository transactionDebitCardBusinessRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionDebitCardBusiness> create(TransactionDebitCardBusinessRequest transactionDebitCardBusinessRequest) {
        return clientServiceWC.findDebitCardBusinessById(transactionDebitCardBusinessRequest.getIdDebitCardBusiness())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(debitCardBusinessResponse -> this.businessLogicTransaction(transactionDebitCardBusinessRequest, debitCardBusinessResponse));
    }

    @Override
    public Mono<TransactionDebitCardBusiness> update(TransactionDebitCardBusiness transactionDebitCardBusiness) {
        transactionDebitCardBusiness.setUpdatedAt(LocalDateTime.now());
        return clientServiceWC.findDebitCardBusinessById(transactionDebitCardBusiness.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(CreditCardBusiness -> this.updateTransaction(transactionDebitCardBusiness));
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionDebitCardBusinessRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionDebitCardBusiness> findById(String id) {
        return transactionDebitCardBusinessRepository.findById(id);
    }

    @Override
    public Flux<TransactionDebitCardBusiness> findAll() {
        return transactionDebitCardBusinessRepository.findAll();
    }

    @Override
    public Flux<TransactionDebitCardBusiness> findByIdDebitCardBusiness(String idDebitCardBusiness) {
        return transactionDebitCardBusinessRepository.findByIdDebitCardBusiness(idDebitCardBusiness);
    }

    private Mono<TransactionDebitCardBusiness> businessLogicTransaction(TransactionDebitCardBusinessRequest transactionDebitCardBusinessRequest, DebitCardBusiness debitCardBusiness){

        TransactionDebitCardBusiness transactionDebitCardBusiness = new TransactionDebitCardBusiness();
        transactionDebitCardBusiness.setId(new ObjectId().toString());
        transactionDebitCardBusiness.setIdDebitCardBusiness(transactionDebitCardBusinessRequest.getIdDebitCardBusiness());
        transactionDebitCardBusiness.setTransactionTypeDebitCard(transactionDebitCardBusinessRequest.getTransactionTypeDebitCard());
        transactionDebitCardBusiness.setTransactionDate(LocalDateTime.now());
        transactionDebitCardBusiness.setCreatedAt(LocalDateTime.now());
        transactionDebitCardBusiness.setAmount(transactionDebitCardBusinessRequest.getAmount());

        if(transactionDebitCardBusinessRequest.getTransactionTypeDebitCard().equals(TransactionTypePasPro.RETIRO.name())){
            debitCardBusiness.getAccounts().stream().sorted(Comparator.comparing(Account::getOrder)).forEach(account -> {
                clientServiceWC.findCurrentAccountBusinessById(account.getIdAccount())
                        .switchIfEmpty(Mono.error(new ModelNotFoundException("CURRENT ACCOUNT BUSINESS NOT FOUND")))
                        .flatMap(currentAccountBusinessResponse -> {
                            if(currentAccountBusinessResponse.getAmount() > transactionDebitCardBusinessRequest.getAmount()){
                                currentAccountBusinessResponse.setAmount(currentAccountBusinessResponse.getAmount() - transactionDebitCardBusinessRequest.getAmount());
                                transactionDebitCardBusinessRequest.setAmount(0);
                            }
                            else{
                                transactionDebitCardBusinessRequest.setAmount(transactionDebitCardBusinessRequest.getAmount() - currentAccountBusinessResponse.getAmount());
                                currentAccountBusinessResponse.setAmount(0);
                            }

                            return clientServiceWC.updateCurrentAccountBusiness(currentAccountBusinessResponse)
                                    .switchIfEmpty(Mono.error(new ModelNotFoundException("ERROR")));
                        });
            });

            return this.registerTransaction(debitCardBusiness, transactionDebitCardBusiness);
        }

        return Mono.error(new ModelNotFoundException("Invalid option"));
    }

    private Mono<TransactionDebitCardBusiness> registerTransaction(DebitCardBusiness debitCardBusiness, TransactionDebitCardBusiness transactionDebitCardBusiness){
        transactionDebitCardBusiness.setDebitCardBusiness(debitCardBusiness);
        return transactionDebitCardBusinessRepository.save(transactionDebitCardBusiness);
    }

    private Mono<TransactionDebitCardBusiness> updateTransaction(TransactionDebitCardBusiness transactionDebitCardBusiness){
        transactionDebitCardBusiness.setUpdatedAt(LocalDateTime.now());
        return transactionDebitCardBusinessRepository.save(transactionDebitCardBusiness);
    }
}
