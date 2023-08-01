package org.example;
import lombok.Data;

@Data
public class People {
    String firstName;
    String secondName;
    String age;

    public People(String firstName, String secondName, String age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
}
