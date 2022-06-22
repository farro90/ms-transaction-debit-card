package com.nttdata.bc19.mstransactiondebitcard.model.responseWC;

import lombok.Data;

@Data
public class Account {
    private String accountType;
    private String idAccount;
    private int order;
}
