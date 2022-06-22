package com.nttdata.bc19.mstransactiondebitcard.request;

import lombok.Data;

@Data
public class TransactionDebitCardBusinessRequest {
    private String idDebitCardBusiness;
    private double amount;
    private String transactionTypeDebitCard;
}
