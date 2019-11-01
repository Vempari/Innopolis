package part1.lesson2;

import java.lang.*;
import java.util.*;

public class HashMapTable<K, V> implements Map<K, V> {
    int arraySize = 16;
    HashObject[] map = new HashObject[arraySize];
    int counter = 0;

    public int makeIndex(Object key) {
        int result = key.hashCode() % arraySize;
        if (result < 0) {
            result = -result;
        }
        while (map[result] != null && key.hashCode() != map[result].getKey().hashCode()) {
            result++;
        }
        return result;
    }

    @Override
    public V get(Object key) {
        return (V) map[makeIndex(key)].getValue();
    }

    @Override
    public V put(K key, V value) {
        try {
            if (counter >= arraySize) {
                arraySize = arraySize + arraySize;
                map = Arrays.copyOf(map, arraySize);
            }
            if (map[makeIndex(key)] == null) {
                counter++;
            }
            map[makeIndex(key)] = new HashObject(key, value);
            return null;
        } catch (RuntimeException e) {
            System.out.println("Нельзя дабавлять null");
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if (map[makeIndex(key)] != null) {
            map[makeIndex(key)] = null;
        }
        counter--;
        return null;
    }

    @Override //И это тоже
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends K> set = m.keySet();
        for (K s : set) {
            this.put(s, m.get(s));
        }
    }
    @Override
    public void clear() {
        for (int i = 0; i < arraySize; i++) {
            map[i] = null;
        }
        counter = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < arraySize; i++) {
            if (map[i] != null) {
                set.add((K) map[i].getKey());
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> col = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            if (map[i] != null) {
                col.add((V) map[i].getValue());
            }
        }
        return col;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < arraySize; i++) {
            if (map[i] != null) {
                set.add(map[i]);
            }
        }
        return set;
    }

    @Override
    public boolean containsKey(Object key) {
        if (map[makeIndex(key)] != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < arraySize; i++) {
            if (map[i] != null && map[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
     public int size() {
        return counter;
     }

    @Override
    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        }
        return false;
     }

}
