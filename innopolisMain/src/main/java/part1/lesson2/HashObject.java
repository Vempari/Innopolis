package part1.lesson2;

import java.util.Map;

public class HashObject<K, V> implements Map.Entry<K, V> {
    K key;
    V value;

    public HashObject(K key, V value) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }


    public V getValue() {
        return value;
    }

    public Object setValue(Object value) {
        this.value = (V) value;
        return value;
    }
}
