package com.nttdata.bc19.mstransactiondebitcard.model;

import com.nttdata.bc19.mstransactiondebitcard.model.responseWC.DebitCardPerson;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionDebitCardPerson extends BaseModel{
    //private  String code;
    private String idDebitCardPerson;
    private DebitCardPerson debitCardPerson;
    private LocalDateTime transactionDate;
    private String transactionTypeDebitCard;
    private double amount;
}
