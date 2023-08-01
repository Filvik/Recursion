package org.example;

import lombok.Data;

@Data
public class PeopleChild {
    String operation;
    String operationOperand1;
    String operationOperand2;
    PeopleChild Children1;
    PeopleChild Children2;


    public PeopleChild(String operation, String operationOperand1, String operationOperand2) {
        this.operation = operation;
        this.operationOperand1 = operationOperand1;
        this.operationOperand2 = operationOperand2;
    }

    public PeopleChild(String operation, PeopleChild children1, PeopleChild children2) {
        this.operation = operation;
        Children1 = children1;
        Children2 = children2;
    }
}
