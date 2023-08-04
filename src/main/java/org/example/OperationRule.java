package org.example;

import java.util.*;

import static java.util.Map.entry;

public class OperationRule {
    public static final Map<OperationEnum, List<FieldEnum>> OPERATION_RULE = Map.ofEntries(
            entry(OperationEnum.EQUALS, new ArrayList<>(Arrays.asList(FieldEnum.FIRSTNAME, FieldEnum.SECONDNAME, FieldEnum.AGE))),
            entry(OperationEnum.MORE, new ArrayList<>(List.of(FieldEnum.AGE))),
            entry(OperationEnum.LESS, new ArrayList<>(List.of(FieldEnum.AGE)))
    );

    public static final List<OperationEnum> LOGIC_OPERATION = new ArrayList<>(Arrays.asList(OperationEnum.OR, OperationEnum.AND));
}
