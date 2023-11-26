package com.example.popovich9.Models;

public class SubAccount {
    private Long id, accountPlanID;
    private String name, number;
    private Accounts accounts;

    public SubAccount() {
    }

    public SubAccount(Long id, Long accountPlanID, String name,
                      String number, Accounts accounts) {
        this.id = id;
        this.accountPlanID = accountPlanID;
        this.name = name;
        this.number = number;
        this.accounts = accounts;
    }

    public SubAccount(Long accountPlanID, String name, String number, Accounts accounts) {
        this.accountPlanID = accountPlanID;
        this.name = name;
        this.number = number;
        this.accounts = accounts;
    }

    public SubAccount(String name, String number, Accounts accounts) {
        this.name = name;
        this.number = number;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountPlanID() {
        return accountPlanID;
    }

    public void setAccountPlanID(Long accountPlanID) {
        this.accountPlanID = accountPlanID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Accounts getAccount() {
        return accounts;
    }

    public void setAccount(Accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "SubAccount{" +
                "id=" + id +
                ", accountPlanID=" + accountPlanID +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
