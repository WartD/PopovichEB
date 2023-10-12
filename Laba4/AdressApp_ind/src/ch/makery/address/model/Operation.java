package ch.makery.address.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Operation {

    private final IntegerProperty id;
    private final IntegerProperty dealId;
    private final IntegerProperty subAccountId;
    private final IntegerProperty number;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty type;
    private final DoubleProperty sum;
    private final DoubleProperty saldoInput;
    private final DoubleProperty saldoOutput;

    public Operation() {
        this(0, 0, 0, 0, null, "", 0.0, 0.0, 0.0);
    }

    public Operation(int id, int dealId, int subAccountId, int number, LocalDate date, String type, double sum, double saldoInput, double saldoOutput) {
        this.id = new SimpleIntegerProperty(id);
        this.dealId = new SimpleIntegerProperty(dealId);
        this.subAccountId = new SimpleIntegerProperty(subAccountId);
        this.number = new SimpleIntegerProperty(number);
        this.date = new SimpleObjectProperty<>(date);
        this.type = new SimpleStringProperty(type);
        this.sum = new SimpleDoubleProperty(sum);
        this.saldoInput = new SimpleDoubleProperty(saldoInput);
        this.saldoOutput = new SimpleDoubleProperty(saldoOutput);
    }
    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public int getDealId() {
        return dealId.get();
    }
    public void setDealId(int dealId) {
        this.dealId.set(dealId);
    }
    public IntegerProperty dealIdProperty() {
        return dealId;
    }
    public int getSubAccountId() {
        return subAccountId.get();
    }
    public void setSubAccountId(int subAccountId) {
        this.subAccountId.set(subAccountId);
    }
    public IntegerProperty subAccountIdProperty() {
        return subAccountId;
    }
    public int getNumber() {
        return number.get();
    }
    public void setNumber(int number) {
        this.number.set(number);
    }
    public IntegerProperty numberProperty() {
        return number;
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
    public String getType() {
        return type.get();
    }
    public void setType(String type) {
        this.type.set(type);
    }
    public StringProperty typeProperty() {
        return type;
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
    public double getSaldoInput() {
        return saldoInput.get();
    }
    public void setSaldoInput(double saldoInput) {
        this.saldoInput.set(saldoInput);
    }
    public DoubleProperty saldoInputProperty() {
        return saldoInput;
    }
    public double getSaldoOutput() {
        return saldoOutput.get();
    }
    public void setSaldoOutput(double saldoOutput) {
        this.saldoOutput.set(saldoOutput);
    }
    public DoubleProperty saldoOutputProperty() {
        return saldoOutput;
    }
}
