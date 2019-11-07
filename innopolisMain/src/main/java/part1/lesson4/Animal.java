package part1.lesson4;

public class Animal {
    private String name;
    private int age;
    private String type;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
