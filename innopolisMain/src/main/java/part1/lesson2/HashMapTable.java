package part1.lesson2;

import java.lang.*;
import java.util.Arrays;

public class HashMapTable {
    int arraySize = 16;
    HashObject[] map = new HashObject[arraySize];
    int counter = 0;

    public Object getKey(Object key) {
        return map[key.hashCode() % arraySize].getValue();
    }

    public void put(Object key, Object value) {
        map[key.hashCode() % arraySize] = new HashObject(key, value);
        HashObject[] newMap = new HashObject[++arraySize];
        map = Arrays.copyOf(map, map.length + 1);
        counter++;
    }

    public void remove(Object key) {
        if (map[key.hashCode() % arraySize] != null) {
            map[key.hashCode() % arraySize] = null;
        }
        counter--;
    }

    public void set(Object key, Object value) {
        if (map[key.hashCode() % arraySize] != null) {
            map[key.hashCode() % arraySize].setValue(value);
        }
    }

    public boolean containsKey(Object key) {
        if (map[key.hashCode() % arraySize] != null) {
            return true;
        }
        return false;
    }

     public int size() {
        return counter;
     }


}
