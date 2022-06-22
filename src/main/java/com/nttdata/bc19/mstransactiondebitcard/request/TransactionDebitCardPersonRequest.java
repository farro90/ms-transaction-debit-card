package com.nttdata.bc19.mstransactiondebitcard.request;

import lombok.Data;

@Data
public class TransactionDebitCardPersonRequest {
    private String idDebitCardPerson;
    private double amount;
    private String transactionTypeDebitCard;
}
