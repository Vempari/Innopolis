package part1.lesson2;

import java.lang.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class HashMapTable {
    int arraySize = 16;
    HashObject[] map = new HashObject[arraySize];
    int counter = 0;

    public int makeIndex(Object key) {
        int result = key.hashCode() % arraySize;
        if (result < 0) {
            result = -result;
        }
        while (map[result] != null && key.hashCode() != map[result].getKey()) {
            result++;
        }
        return result;
    }

    public Object getKey(Object key) {
        return map[makeIndex(key)].getValue();
    }

    public void put(Object key, Object value) {
        try {
            if (counter >= arraySize) {
                arraySize ++;
                map = Arrays.copyOf(map, arraySize);
            }
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
