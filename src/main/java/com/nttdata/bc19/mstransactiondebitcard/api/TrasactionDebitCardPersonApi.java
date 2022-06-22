package com.nttdata.bc19.mstransactiondebitcard.api;

import com.nttdata.bc19.mstransactiondebitcard.model.TransactionDebitCardPerson;
import com.nttdata.bc19.mstransactiondebitcard.request.TransactionDebitCardPersonRequest;
import com.nttdata.bc19.mstransactiondebitcard.service.ITransactionDebitCardPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/debit-card/person")
public class TrasactionDebitCardPersonApi {

    @Autowired
    private ITransactionDebitCardPersonService transactionDebitCardPersonService;

    @PostMapping
    public Mono<TransactionDebitCardPerson> create(@RequestBody TransactionDebitCardPersonRequest transactionDebitCardPersonRequest){
        return transactionDebitCardPersonService.create(transactionDebitCardPersonRequest);
    }

    @PutMapping
    public Mono<TransactionDebitCardPerson> update(@RequestBody TransactionDebitCardPerson transactionDebitCardPerson){
        return transactionDebitCardPersonService.update(transactionDebitCardPerson);
    }

    @GetMapping
    public Flux<TransactionDebitCardPerson> findAll(){
        return transactionDebitCardPersonService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionDebitCardPerson> findById(@PathVariable String id){ return transactionDebitCardPersonService.findById(id); }

    @GetMapping("/findByIdDebitCardPerson/{idDebitCardPerson}")
    public Flux<TransactionDebitCardPerson> findByIdDebitCardPerson(@PathVariable String idDebitCardPerson){
        return transactionDebitCardPersonService.findByIdDebitCardPerson(idDebitCardPerson);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionDebitCardPersonService.deleteById(id);
    }
}
