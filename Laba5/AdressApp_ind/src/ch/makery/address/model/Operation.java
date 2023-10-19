package ch.makery.address.model;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Operation {

    private final ObjectProperty<LocalDate> date;
    private final StringProperty number;
    private final DoubleProperty sum;
    private final StringProperty transactionType;
    private final DoubleProperty inputBalance;
    private final DoubleProperty outputBalance;

    public Operation() {
        this.date = new SimpleObjectProperty<>(LocalDate.now());
        this.number = new SimpleStringProperty("");
        this.sum = new SimpleDoubleProperty(0.0);
        this.transactionType = new SimpleStringProperty("Default Transaction");
        this.inputBalance = new SimpleDoubleProperty(0.0);
        this.outputBalance = new SimpleDoubleProperty(0.0);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public double getSum() {
        return sum.get();
    }

    public void setSum(double sum) {
        this.sum.set(sum);
    }

    public DoubleProperty sumProperty() {
        return sum;
    }

    public String getTransactionType() {
        return transactionType.get();
    }

    public void setTransactionType(String transactionType) {
        this.transactionType.set(transactionType);
    }

    public StringProperty transactionTypeProperty() {
        return transactionType;
    }

    public double getInputBalance() {
        return inputBalance.get();
    }

    public void setInputBalance(double inputBalance) {
        this.inputBalance.set(inputBalance);
    }

    public DoubleProperty inputBalanceProperty() {
        return inputBalance;
    }

    public double getOutputBalance() {
        return outputBalance.get();
    }

    public void setOutputBalance(double outputBalance) {
        this.outputBalance.set(outputBalance);
    }

    public DoubleProperty outputBalanceProperty() {
        return outputBalance;
    }
}
