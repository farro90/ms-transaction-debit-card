package com.nttdata.bc19.mstransactiondebitcard.api;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardBusiness;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardBusinessRequest;
import com.nttdata.bc19.mstransactiondebitcard.service.ITransactionDebitCardBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/debit-card/business")
public class TrasactionDebitCardBusinessApi {

    @Autowired
    private ITransactionDebitCardBusinessService transactionDebitCardBusinessService;

    @PostMapping
    public Mono<TransactionDebitCardBusiness> create(@RequestBody TransactionDebitCardBusinessRequest transactionDebitCardBusinessRequest){
        return transactionDebitCardBusinessService.create(transactionDebitCardBusinessRequest);
    }

    @PutMapping
    public Mono<TransactionDebitCardBusiness> update(@RequestBody TransactionDebitCardBusiness transactionDebitCardBusiness){
        return transactionDebitCardBusinessService.update(transactionDebitCardBusiness);
    }

    @GetMapping
    public Flux<TransactionDebitCardBusiness> findAll(){
        return transactionDebitCardBusinessService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionDebitCardBusiness> findById(@PathVariable String id){ return transactionDebitCardBusinessService.findById(id); }

    @GetMapping("/find/{idDebitCardBusiness}")
    public Flux<TransactionDebitCardBusiness> findByIdPasProPerCli(@PathVariable String idDebitCardBusiness){
        return transactionDebitCardBusinessService.findByIdDebitCardBusiness(idDebitCardBusiness);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionDebitCardBusinessService.deleteById(id);
    }
}
