package collections;

import java.util.*;

public class HashMap implements java.util.Map {

    HashTable table;

    public HashMap() {
        table = new HashTable();
    }

    @Override
    public int size() {
        return table.Size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return table.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object get(Object key) {
        return table.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        Pair pair = new Pair(key, value);
        table.add(pair);

        return key;
    }

    @Override
    public Object remove(Object key) {
        return table.remove(key);
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return table.toString();
    }
}
