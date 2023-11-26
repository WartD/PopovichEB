package com.example.popovich9.Models;

public class Accounts {
    private Long id;
    private String name, type, number;
    public Accounts(Long id, String name, String type, String number) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public Accounts() {
    }

    public Accounts(String name, String type, String number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
