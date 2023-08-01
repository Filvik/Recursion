package org.example;

public enum OperationEnum {

    MORE (">"),
    LESS ("<"),
    EQUALS ("==");

    private final String value;

    OperationEnum(String value){
        this.value = value;
    }

    public static OperationEnum getOperationEnum(String value){
        OperationEnum[] operationEnum = values();
        for (OperationEnum operation: operationEnum){
            if (operation.value.equals(value)){
                return operation;
            }
        }
        throw new RuntimeException("Ошибка знака операции!");
    }
}
