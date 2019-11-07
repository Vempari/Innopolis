package part1.lesson4;

import java.io.Serializable;
import java.util.Map;

public class Human implements Serializable {
    private int age;
    private String name;
    private String adress;
    private String email;


    public Human(int age, String name, String adress, String email) {
        this.age = age;
        this.name = name;
        this.adress = adress;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }
}
