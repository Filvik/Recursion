package org.example;
import lombok.Data;

@Data
public class People {
    String firstName;
    String secondName;
    int age;

    public People(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
}
