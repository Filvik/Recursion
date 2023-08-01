package org.example;

public class Main {
    static People Viktor = new People("Viktor", "Filippova", 33);
    static People Alexandra = new People("Sasha", "Filippova", 33);
    static People Veronika = new People("Veronika", "Filippova", 5);
    static PeopleService peopleService = new PeopleService();


    public static void main(String[] args) {

        System.out.println(answer(Viktor, peopleService.createYslovie()));
        System.out.println(answer(Alexandra, peopleService.createYslovie()));
        System.out.println(answer(Veronika, peopleService.createYslovie()));

    }
    static boolean answer(People people, PeopleChild peopleChild) {
        return peopleService.people(people, peopleChild);
    }
}
