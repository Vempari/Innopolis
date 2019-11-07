package part1.lesson4;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class ReflectionTaskTest {
    @Test
    public void cleanup_putSomeObjectAndSetDefaultValue_getDefaultValue()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Human human = new Human(12, "Vasya", "Vladivostok", "123@mail.ru");
        ReflectionTask reflectionTask = new ReflectionTask();
        Set<String> set1 = new HashSet<>();
        set1.add("adress");
        set1.add("age");
        Set<String> set2 = new HashSet<>();
        set2.add("name");
        set2.add("email");
        reflectionTask.cleanup(human, set1, set2);
        assertThat(human.getAge(), is(0));
        assertNull(human.getAdress());
    }

    @Test
    public void cleanup_putAnotherObjectAndSetDefaultValue_getDefaultValue()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Animal animal = new Animal("Tom", 8, "Cat");
        ReflectionTask reflectionTask = new ReflectionTask();
        Set<String> set1 = new HashSet<>();
        set1.add("name");
        set1.add("age");
        set1.add("type");
        Set<String> set2 = new HashSet<>();
        reflectionTask.cleanup(animal, set1, set2);
        assertThat(animal.getAge(), is(0));
        assertNull(animal.getName());
    }

    @Test
    public void cleanup_putSomeObjectAndSetMoreFieldsThenObjectFields_getDefaultValue()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Animal animal = new Animal("Tom", 8, "Cat");
        ReflectionTask reflectionTask = new ReflectionTask();
        Set<String> set1 = new HashSet<>();
        set1.add("name");
        set1.add("age");
        set1.add("type");
        set1.add("address");
        set1.add("core");
        set1.add("length");
        Set<String> set2 = new HashSet<>();
        reflectionTask.cleanup(animal, set1, set2);
        assertThat(animal.getAge(), is(0));
        assertNull(animal.getName());
    }

    @Test
    public void cleanup_putMapAndSetDefaultValue_getDefaultValueInMapObjects()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ReflectionTask reflectionTask = new ReflectionTask();
        Map<Integer, Animal> map = new HashMap<>();
        map.put(1, new Animal("Tom", 8, "Cat"));
        map.put(2, new Animal("Jerry", 2, "Mouse"));
        Set<String> set1 = new HashSet<>();
        set1.add("name");
        set1.add("age");
        Set<String> set2 = new HashSet<>();
        set2.add("type");
        reflectionTask.cleanup(map, set1, set2);
        assertThat(map.get(1).getAge(), is(0));
        assertNull(map.get(2).getName());

    }
}
