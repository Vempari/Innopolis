package part01.lesson01;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class task01Test {
    @Test
    public void whenHelloThenSOUT () {
        task01 a = new task01();
        assertThat(a.sayHello(), is("Hello, World!"));
    }
}
