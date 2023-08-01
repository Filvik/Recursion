package org.example;

public class PeopleService {
    private People people;
    private PeopleChild peopleChild;

    public boolean people(People people, PeopleChild peopleChild) {

        if (peopleChild.getChildren1() == null || peopleChild.getChildren2() == null) {

            return switch (peopleChild.getOperation()) {
                case "<" ->
                        (peopleChild.getOperationOperand2().compareTo(getFieldValue(peopleChild.getOperationOperand1(), people)) < 0);
                case ">" ->
                        (peopleChild.getOperationOperand2().compareTo(getFieldValue(peopleChild.getOperationOperand1(), people)) > 0);
                case "==" ->
                        peopleChild.getOperationOperand2().equals(getFieldValue(peopleChild.getOperationOperand1(), people));
                default -> false;
            };
        } else {
            switch (peopleChild.getOperation()) {
                case "and" -> {
                    return people(people, peopleChild.getChildren1()) && people(people, peopleChild.getChildren2());
                }
                case "or" -> {
                    return people(people, peopleChild.getChildren1()) || people(people, peopleChild.getChildren2());
                }
            }
        }
        return false;
    }

    public PeopleChild createYslovie() {

        PeopleChild age1 = new PeopleChild("<", "age", "32");
        PeopleChild age2 = new PeopleChild(">", "age", "40");
        PeopleChild age3 = new PeopleChild("==", "age", "5");
        PeopleChild firstName = new PeopleChild("==", "firstName", "Sasha");
        PeopleChild secondName = new PeopleChild("==", "secondName", "Filippova");
        PeopleChild firstName1 = new PeopleChild("==", "firstName", "Veronika");
        PeopleChild secondName1 = new PeopleChild("==", "secondName", "Filippova");
        PeopleChild firstName2 = new PeopleChild("==", "firstName", "Viktor");
        PeopleChild secondName2 = new PeopleChild("==", "secondName", "Filippov");

        PeopleChild age = new PeopleChild("and", age1, age2);

        PeopleChild name = new PeopleChild("or", firstName, firstName2);
        PeopleChild name1 = new PeopleChild("or", secondName, secondName2);
        PeopleChild nameSum = new PeopleChild("and", name, name1);

        PeopleChild nameWithSV = new PeopleChild("and", age, nameSum);


        return new PeopleChild("or", firstName1, nameWithSV);


    }

    public String getFieldValue(String s, People people) {

        switch (s) {
            case "age" -> {
                return people.getAge();
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
}
