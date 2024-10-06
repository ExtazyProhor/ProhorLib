package com.prohor.personal.stl.structures;

import lombok.ToString;

import java.util.*;

@ToString
public class Counter<T> {
    private final Map<T, Integer> map;

    public Counter() {
        map = new HashMap<>();
    }

    public int getCount(T key) {
        if (!contains(key))
            return 0;
        return map.get(key);
    }

    public void increment(T key) {
        add(key, 1);
    }

    public void decrement(T key) {
        add(key, -1);
    }

    public void add(T key, int count) {
        if (!contains(key))
            create(key);
        map.put(key, map.get(key) + count);
    }

    public void sub(T key, int count) {
        add(key, -count);
    }

    public void set(T key, int count) {
        map.put(key, count);
    }

    public boolean contains(T key) {
        return map.containsKey(key);
    }

    public void create(T key) {
        map.put(key, 0);
    }

    public void remove(T key) {
        map.remove(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int size() {
        return map.size();
    }

    public Set<Map.Entry<T, Integer>> entrySet() {
        return map.entrySet();
    }
}
