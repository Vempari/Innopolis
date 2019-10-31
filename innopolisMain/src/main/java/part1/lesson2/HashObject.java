package part1.lesson2;

import java.util.Objects;

public class HashObject {
    int key;
    Object value;

    public HashObject(Object key, Object value) {
        this.key = key.hashCode();
        this.value = value;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
