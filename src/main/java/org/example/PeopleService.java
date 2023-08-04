package org.example;

import static org.example.OperationEnum.*;
import static org.example.OperationRule.LOGIC_OPERATION;
import static org.example.OperationRule.OPERATION_RULE;

public class PeopleService {

    /**
     * Определяет есть ли данный объект с заданными критериями.
     *
     * @param people      Объект класса People(Объект поиска).
     * @param peopleChild Объект класса PeopleChild(Критерий поиска).
     * @return true or false.
     */
    public boolean people(People people, PeopleChild peopleChild) {

        fieldCorrect(peopleChild);

        return switch (peopleChild.operation) {

            case LESS ->
                    (peopleChild.getOperationOperand2().compareTo(getFieldValue(peopleChild.getOperationOperand1(), people)) < 0);
            case MORE ->
                    (peopleChild.getOperationOperand2().compareTo(getFieldValue(peopleChild.getOperationOperand1(), people)) > 0);
            case EQUALS ->
                    peopleChild.getOperationOperand2().equals(getFieldValue(peopleChild.getOperationOperand1(), people));
            case AND -> people(people, peopleChild.getChildren1()) && people(people, peopleChild.getChildren2());
            case OR -> people(people, peopleChild.getChildren1()) || people(people, peopleChild.getChildren2());
        };
    }

    /**
     * Формирует критерии поиска.
     *
     * @return Объект класса PeopleChild.
     */
    public PeopleChild createYslovie() {

        PeopleChild age1 = new PeopleChild(LESS, "age", "32");
        PeopleChild age2 = new PeopleChild(MORE, "age", "40");
        PeopleChild age3 = new PeopleChild(EQUALS, "age", "5");
        PeopleChild firstName = new PeopleChild(EQUALS, "firstName", "Sasha");
        PeopleChild secondName = new PeopleChild(EQUALS, "secondName", "Filippova");
        PeopleChild firstName1 = new PeopleChild(EQUALS, "firstName", "Veronika");
        PeopleChild secondName1 = new PeopleChild(EQUALS, "secondName", "Filippova");
        PeopleChild firstName2 = new PeopleChild(EQUALS, "firstName", "Viktor");
        PeopleChild secondName2 = new PeopleChild(EQUALS, "secondName", "Filippov");

        PeopleChild age = new PeopleChild(AND, age1, age2);

        PeopleChild name = new PeopleChild(OR, firstName, firstName2);
        PeopleChild name1 = new PeopleChild(OR, secondName, secondName2);
        PeopleChild nameSum = new PeopleChild(AND, name, name1);

        PeopleChild nameWithSV = new PeopleChild(AND, age, nameSum);

        return new PeopleChild(OR, firstName1, nameWithSV);
    }


    /**
     * Получение значения полей объекта.
     *
     * @param s      Значение operation.
     * @param people Объект класса People.
     * @return Значение поля объекта people.
     */
    public String getFieldValue(String s, People people) {
        switch (s) {
            case "age" -> {
                return String.valueOf(people.getAge());
            }
            case "firstName" -> {
                return people.getFirstName();
            }
            case "secondName" -> {
                return people.getSecondName();
            }
        }
        return "";
    }

    /**
     * Проверка полей на корректный знак операции.
     *
     * @param peopleChild Объект класса PeopleChild(Критерий поиска).
     */
    public void fieldCorrect(PeopleChild peopleChild) {

        OperationEnum operation = peopleChild.operation;

        if (peopleChild.getChildren1() == null || peopleChild.getChildren2() == null) {
            if (!OPERATION_RULE.get(operation).contains(FieldEnum.getFieldEnum(peopleChild.operationOperand1))) {
                throw new RuntimeException("Недопустимый тип операции для поля " + peopleChild.operationOperand1);
            }
        }
        else {
            if(!LOGIC_OPERATION.contains(peopleChild.operation)){
                throw new RuntimeException("Недопустимый тип операции:" + peopleChild.operation + ",должен быть AND или OR!");
            }
        }
    }
}
