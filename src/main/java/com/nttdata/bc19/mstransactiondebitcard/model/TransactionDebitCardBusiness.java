package com.nttdata.bc19.mstransactiondebitcard.model;

import com.nttdata.bc19.mstransactiondebitcard.model.responseWC.DebitCardBusiness;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionDebitCardBusiness extends BaseModel{
    //private  String code;
    private String idDebitCardBusiness;
    private DebitCardBusiness debitCardBusiness;
    private LocalDateTime transactionDate;
    private String transactionTypeDebitCard;
    private double amount;
}
