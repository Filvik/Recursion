package org.example;

public enum FieldEnum {
    FIRSTNAME ("firstName"),
    SECONDNAME ("secondName"),
    AGE ("age");

    private final String value;

    FieldEnum(String value){
        this.value = value;
    }

    public static FieldEnum getFieldEnum(String value){
        FieldEnum[] fieldEnum = values();
        for (FieldEnum field: fieldEnum){
            if (field.value.equals(value)){
                return field;
            }
        }
        throw new RuntimeException("Ошибка значения поля!");
    }
}
