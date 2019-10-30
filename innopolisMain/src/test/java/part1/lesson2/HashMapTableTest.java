package part1.lesson2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HashMapTableTest {
    @Test
    public void WhenPutMapThenSize1() {
        HashMapTable a = new HashMapTable();
        HashObject b = new HashObject(1,1);
        HashObject c = new HashObject(1,1);

        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(c.getKey(), is(b.hashCode()));
    }

    @Test
    public void WhenPutInTheSamePlace() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(1, "Hello");
        assertThat(a.size(), is(2));
    }

    @Test
    public void WhenPutMapThenContainsKey() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        assertThat(a.containsKey(1), is(true));
    }


    @Test
    public void WhenPutThenRemoveMapThenSize() {
        HashMapTable a = new HashMapTable();
        a.put("1", "Hello");
        a.remove("1");
        a.put(1, "Vasya");
        assertThat(a.size(), is(1));
    }

    @Test
    public void WhenPutMapThenSetThenNewValue() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.set(1, "Jenya");
        assertThat(a.getKey(1), is("Jenya"));
    }

    @Test
    public void WhenPutMoreThen16() {
        HashMapTable a = new HashMapTable();
        a.put(1, "Hello");
        a.put(4, "Vasya");
        a.put(2, "Hello");
        a.put("3", "Vasya");
        a.put("2", "Hello");
        a.put("as", "Vasya");
        a.put(100, "Hello");
        a.put(63, "Vasya");
        a.put(89, "Hello");
        a.put(84, "Vasya");
        a.put(222, "Hello");
        a.put(12, "Vasya");
        a.put(3333, "Hello");
        a.put(4444, "Vasya");
        a.put(112, "Hello");
        a.put(4321, "Vasya");
        a.put(8888, "Vasya");
        assertThat(a.size(), is(17));
    }

}
