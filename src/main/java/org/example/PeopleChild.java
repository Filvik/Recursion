package org.example;

import lombok.Data;
import lombok.NonNull;

@Data
public class PeopleChild {
    OperationEnum operation;
    String operationOperand1;
    String operationOperand2;
    PeopleChild Children1;
    PeopleChild Children2;


    public PeopleChild(@NonNull OperationEnum operation, @NonNull String operationOperand1, @NonNull String operationOperand2) {
        this.operation = operation;
        this.operationOperand1 = operationOperand1;
        this.operationOperand2 = operationOperand2;
    }

    public PeopleChild(@NonNull OperationEnum operation, @NonNull PeopleChild children1, @NonNull PeopleChild children2) {
        this.operation = operation;
        Children1 = children1;
        Children2 = children2;
    }
}
