package com.example.popovich9;

public class Operation {
    private Long id, dealID, subAccountID;
    private String number, data, type, sum, saldoInput, saldoOutput;
    private Deal deal;
    private SubAccount subAccount;

    public Operation() {
    }

    public Operation(Long id, Long dealID, Long subAccountID,
                     String number, String data, String type,
                     String sum, String saldoInput, String saldoOutput,
                     Deal deal, SubAccount subAccount) {
        this.id = id;
        this.dealID = dealID;
        this.subAccountID = subAccountID;
        this.number = number;
        this.data = data;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
    }

    public Operation(Long dealID, Long subAccountID, String number,
                     String data, String type, String sum, String saldoInput,
                     String saldoOutput, Deal deal, SubAccount subAccount) {
        this.dealID = dealID;
        this.subAccountID = subAccountID;
        this.number = number;
        this.data = data;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
    }

    public Operation(String number, String data, String type, String sum,
                     String saldoInput, String saldoOutput, Deal deal,
                     SubAccount subAccount) {
        this.number = number;
        this.data = data;
        this.type = type;
        this.sum = sum;
        this.saldoInput = saldoInput;
        this.saldoOutput = saldoOutput;
        this.deal = deal;
        this.subAccount = subAccount;
    }
}
