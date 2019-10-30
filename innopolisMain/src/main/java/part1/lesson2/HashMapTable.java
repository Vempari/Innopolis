package part1.lesson2;

import java.lang.*;
import java.util.Arrays;
import java.util.Objects;

public class HashMapTable {
    int arraySize = 1000000;
    HashObject[] map = new HashObject[arraySize];
    int counter = 0;

    public int makeIndex(Object key) {
        if (key.hashCode() > arraySize) {
            return key.hashCode() % arraySize;
        }
        if (key.hashCode() < 0) {
            return arraySize + key.hashCode();
        }
        return key.hashCode();
    }

    public Object getKey(Object key) {
        return map[makeIndex(key)].getValue();
    }

    public void put(Object key, Object value) {
        try {
            if (map[makeIndex(key)] == null) {
                counter++;
            }
            map[makeIndex(key)] = new HashObject(key, value);
        } catch (RuntimeException e) {
            System.out.println("Нельзя дабавлять null");
        }
    }

    public void remove(Object key) {
        if (map[makeIndex(key)] != null) {
            map[makeIndex(key)] = null;
        }
        counter--;
    }

    public void set(Object key, Object value) {
        if (map[makeIndex(key)] != null) {
            map[makeIndex(key)].setValue(value);
        }
    }

    public boolean containsKey(Object key) {
        if (map[makeIndex(key)] != null) {
            return true;
        }
        return false;
    }

     public int size() {
        return counter;
     }

}
