package com.example.popovich9;

public class SubAccount {
    private Long id, accountPlanID;
    private String name, number;
    private AccountPlan accountPlan;

    public SubAccount() {
    }

    public SubAccount(Long id, Long accountPlanID, String name,
                      String number, AccountPlan accountPlan) {
        this.id = id;
        this.accountPlanID = accountPlanID;
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
    }

    public SubAccount(Long accountPlanID, String name, String number, AccountPlan accountPlan) {
        this.accountPlanID = accountPlanID;
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
    }

    public SubAccount(String name, String number, AccountPlan accountPlan) {
        this.name = name;
        this.number = number;
        this.accountPlan = accountPlan;
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

    public AccountPlan getAccountPlan() {
        return accountPlan;
    }

    public void setAccountPlan(AccountPlan accountPlan) {
        this.accountPlan = accountPlan;
    }

    @Override
    public String toString() {
        return "SubAccount{" +
                "id=" + id +
                ", accountPlanID=" + accountPlanID +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", accountPlan=" + accountPlan +
                '}';
    }
}
