package part1.lesson4;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Task1Test {
    @Test
    public void whenPutSomeObjectAndCleanup() throws NoSuchFieldException, IllegalAccessException {
        Human human = new Human(12, "Vasya", "Vladivostok", "123@mail.ru");
        Task1 task1 = new Task1();
        Set<String> set1 = new HashSet<>();
        set1.add("age");
        set1.add("name");
        set1.add("adress");
        set1.add("email");
        Set<String> set2 = new HashSet<>();
        task1.cleanup(human, set1, set2);
        assertThat(human.getAge(), is(0));
    }
}
