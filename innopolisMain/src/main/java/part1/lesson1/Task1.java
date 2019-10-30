package part1.lesson1;

public class Task1 {
    public static void main(String[] args) {

        Task1 a = new Task1();
        Task1 b = new Task1();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


    public String sayHello() {
        return "Hello, World!";
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
