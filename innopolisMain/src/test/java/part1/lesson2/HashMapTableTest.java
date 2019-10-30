package part1.lesson2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HashMapTableTest {
    @Test
    public void whenPutMapThenSize1() {
        HashMapTable a = new HashMapTable();

        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.size(), is(2));
    }

    @Test
    public void whenPutInTheSamePlace() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(1, "aaaa");
        assertThat(a.size(), is(1));
    }

    @Test
    public void whenPutMapThenContainsKey() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsKey(1), is(true));
    }

    @Test
    public void whenPutMapThenContainsWrongKey() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsKey(5), is(false));
    }


    @Test
    public void whenPutThenRemoveMapThenSize() {
        HashMapTable a = new HashMapTable();
        a.put("1", "Hello");
        a.remove("1");
        a.put(1, "Vasya");
        assertThat(a.size(), is(1));
    }

    @Test
    public void whenPutMapThenSetThenNewValue() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.set(1, "Jenya");
        assertThat(a.getKey(1), is("Jenya"));
    }

    @Test
    public void whenPutMoreThen16() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.put(2, "a");
        a.put(-99, "b");
        a.put(400, "c");
        a.put(1234, "d");
        a.put(100, "e");
        a.put(63, "f");
        a.put("89", "g");
        a.put(84, "h");
        a.put(222, "i");
        a.put(12, "j");
        a.put("3333", "k");
        a.put(new HashObject(2, "bbb"), "l");
        a.put(112, "m");
        a.put(4321, "n");
        a.put(8888, "o");
        assertThat(a.size(), is(17));
    }

    @Test
    public void whenNullPutInside() {
        HashMapTable a = new HashMapTable();
        a.put(null, null);
        assertThat("Нельзя дабавлять null", is("Нельзя дабавлять null"));
    }
}
