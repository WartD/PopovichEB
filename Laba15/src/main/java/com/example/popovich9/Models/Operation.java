package com.example.popovich9.Models;

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


    public Long getId() {
        return id;
    }

    public Long getDealID() {
        return dealID;
    }

    public Long getSubAccountID() {
        return subAccountID;
    }

    public String getNumber() {
        return number;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String getSum() {
        return sum;
    }

    public String getSaldoInput() {
        return saldoInput;
    }

    public String getSaldoOutput() {
        return saldoOutput;
    }

    public Deal getDeal() {
        return deal;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDealID(Long dealID) {
        this.dealID = dealID;
    }

    public void setSubAccountID(Long subAccountID) {
        this.subAccountID = subAccountID;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setSaldoInput(String saldoInput) {
        this.saldoInput = saldoInput;
    }

    public void setSaldoOutput(String saldoOutput) {
        this.saldoOutput = saldoOutput;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dealID=" + dealID +
                ", subAccountID=" + subAccountID +
                ", number='" + number + '\'' +
                ", data='" + data + '\'' +
                ", type='" + type + '\'' +
                ", sum='" + sum + '\'' +
                ", saldoInput='" + saldoInput + '\'' +
                ", saldoOutput='" + saldoOutput + '\'' +
                ", deal=" + deal +
                ", subAccount=" + subAccount +
                '}';
    }
}
