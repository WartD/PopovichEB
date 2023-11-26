package com.example.popovich9.Models;

public class Deal {
    private Long id;
    private String agreement, tiker, order, number, data,
            quantity, price, totalCost, trader, comission;

    public Deal() {
    }

    public Deal(Long id, String agreement, String tiker,
                String order, String number, String data,
                String quantity, String price, String totalCost,
                String trader, String comission) {
        this.id = id;
        this.agreement = agreement;
        this.tiker = tiker;
        this.order = order;
        this.number = number;
        this.data = data;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        this.trader = trader;
        this.comission = comission;
    }

    public Deal(String agreement, String tiker, String order,
                String number, String data, String quantity, String price,
                String totalCost, String trader, String comission) {
        this.agreement = agreement;
        this.tiker = tiker;
        this.order = order;
        this.number = number;
        this.data = data;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        this.trader = trader;
        this.comission = comission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getTiker() {
        return tiker;
    }

    public void setTiker(String tiker) {
        this.tiker = tiker;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getComission() {
        return comission;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", agreement='" + agreement + '\'' +
                ", tiker='" + tiker + '\'' +
                ", order='" + order + '\'' +
                ", number='" + number + '\'' +
                ", data='" + data + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", totalCost='" + totalCost + '\'' +
                ", trader='" + trader + '\'' +
                ", comission='" + comission + '\'' +
                '}';
    }
}
