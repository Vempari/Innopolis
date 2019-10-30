package part1.lesson2;

import java.util.Objects;

public class HashObject {
    int Key;
    Object Value;

    public HashObject(Object key, Object value) {
        Key = key.hashCode();
        Value = value;
    }

    public int getKey() {
        return Key;
    }

    public void setKey(int key) {
        Key = key;
    }

    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashObject that = (HashObject) o;
        return Key == that.Key &&
                Objects.equals(Value, that.Value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Key, Value);
    }
}
