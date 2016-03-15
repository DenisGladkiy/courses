package com.courses.spalah.multimap;

import java.util.*;

/**
 * Created by Denis on 15.03.2016.
 */
public class MyMultiMap<K, V> implements MultiMap<K, V> {
    private Map<K, Collection<V>> map;
    private Collection<V> values;
    private int size;

    public MyMultiMap() {
        map = new HashMap<>();
    }

    @Override
    public boolean put(K key, V value) {
        if (map.containsKey(key)) {
            values = map.get(key);
            putEntry(key, value);
        } else {
            values = new ArrayList<>();
            putEntry(key, value);
        }
        size++;
        return true;
    }

    @Override
    public Collection<V> get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            values.clear();
            return values;
        }
    }

    @Override
    public Collection<V> removeAll(K key) {
        if (map.containsKey(key)) {
            values = map.get(key);
            size -= values.size();
            map.remove(key);
            return values;
        } else {
            values.clear();
            return values;
        }
    }

    @Override
    public boolean remove(K key, V value) {
        if (map.containsKey(key)) {
            values = map.get(key);
            if (values.contains(value)) {
                values.remove(value);
                size--;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Collection<V> allValues() {
        Collection<V> all = new ArrayList<>();
        for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
            all.addAll(entry.getValue());
        }
        return all;
    }

    @Override
    public boolean containsValue(V value) {
        for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
            if (entry.getValue().contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void putEntry(K key, V value) {
        values.add(value);
        map.put(key, values);
    }
}
