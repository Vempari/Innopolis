package part1.lesson1;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class Task1Test {
    @Test
    public void whenHelloThenSOUT() {
        Task1 a = new Task1();
        assertThat(a.sayHello(), is("Hello, World!"));
    }
}
