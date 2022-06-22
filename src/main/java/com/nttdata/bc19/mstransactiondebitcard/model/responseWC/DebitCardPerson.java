package com.nttdata.bc19.mstransactiondebitcard.model.responseWC;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class DebitCardPerson extends BaseModel{
    private String debitCardNumber;
    private LocalDateTime deliveryDate;
    private String idPersonClient;
    private List<Account> accounts;
}
