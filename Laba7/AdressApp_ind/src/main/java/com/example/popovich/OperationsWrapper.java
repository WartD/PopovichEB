package com.example.popovich;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "operations")
public class OperationsWrapper {

    private List<Operation> operations;

    @XmlElement(name = "operation")
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
