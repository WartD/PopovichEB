package com.example.popovich;

public class Operation {
    String number, date, sum, transactionType, inputBalance, outputBalance;

    public Operation(String number, String date, String sum, String transactionType, String inputBalance, String outputBalance) {
        this.number = number;
        this.date = date;
        this.sum = sum;
        this.transactionType = transactionType;
        this.inputBalance = inputBalance;
        this.outputBalance = outputBalance;
    }

    public Operation(){

    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }

    public String getSum() {
        return sum;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getInputBalance() {
        return inputBalance;
    }

    public String getOutputBalance() {
        return outputBalance;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setInputBalance(String inputBalance) {
        this.inputBalance = inputBalance;
    }

    public void setOutputBalance(String outputBalance) {
        this.outputBalance = outputBalance;
    }
}
