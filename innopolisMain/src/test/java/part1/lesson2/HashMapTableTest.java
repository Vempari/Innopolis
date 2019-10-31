package part1.lesson2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HashMapTableTest {
    @Test
    public void whenPutMapThenSize1() {
        HashMapTable<Integer, String> a = new HashMapTable<>();

        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.size(), is(2));
    }

    @Test
    public void whenPutInTheSamePlace() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(1, "aaaa");
        assertThat(a.size(), is(1));
    }

    @Test
    public void whenPutMapThenContainsKey() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsKey(1), is(true));
    }

    @Test
    public void whenPutMapThenContainsWrongKey() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsKey(5), is(false));
    }

    @Test
    public void whenPutMapThenContainsValue() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsValue("Hello"), is(true));
    }

    @Test
    public void whenMapIsEmty() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        assertThat(a.isEmty(), is(true));
    }

    @Test
    public void whenPutThenRemoveMapThenSize() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.remove(1);
        a.put(1, "Vasya");
        assertThat(a.size(), is(1));
    }

    @Test
    public void whenPutMapThenSetThenNewValue() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.keySet(1, "Jenya");
        assertThat(a.get(1), is("Jenya"));
    }

    @Test
    public void whenPutMoreThen16() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.put(2, "a");
        a.put(-99, "b");
        a.put(400, "c");
        a.put(1234, "d");
        a.put(100, "e");
        a.put(63, "f");
        a.put(89, "g");
        a.put(84, "h");
        a.put(222, "i");
        a.put(12, "j");
        a.put(1234567, "k");
        a.put(2134567, "l");
        a.put(112, "m");
        a.put(4321, "n");
        a.put(8888, "o");
        assertThat(a.size(), is(17));
    }

    @Test
    public void whenPutAndClear() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.put(2, "a");
        a.put(-99, "b");
        a.put(400, "c");
        a.put(1234, "d");
        a.put(100, "e");
        a.put(63, "f");
        a.put(89, "g");
        a.put(84, "h");
        a.put(222, "i");
        a.put(12, "j");
        a.put(1234567, "k");
        a.put(2134567, "l");
        a.put(112, "m");
        a.put(4321, "n");
        a.put(8888, "o");
        a.clear();
        assertThat(a.size(), is(0));
    }

    @Test
    public void when100Things() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        for(int i = 0; i < 100; i++) {
            a.put(i, "i+i");
        }
        assertThat(a.size(), is(100));
    }

    @Test
    public void whenNullPutInside() {
        HashMapTable<Integer, String> a = new HashMapTable<>();
        a.put(null, null);
        assertThat("Нельзя дабавлять null", is("Нельзя дабавлять null"));
    }
}
