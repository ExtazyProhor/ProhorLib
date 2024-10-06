package com.prohor.personal.stl.structures.maps;

import java.util.*;

public class MultiHashMap<K, V> implements MultiMap<K, V> {
    protected Map<K, List<V>> map;

    public MultiHashMap() {
        map = new HashMap<>();
    }

    public MultiHashMap(MultiHashMap<K, V> multiHashMap) {
        map = new HashMap<>(multiHashMap.map);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new MultiHashMap<>(this);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<V> getAll(K key) {
        return Collections.unmodifiableList(map.get(key));
    }

    @Override
    public V getFirst(K key) {
        List<V> list = map.get(key);
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public V getLast(K key) {
        List<V> list = map.get(key);
        if (list.isEmpty())
            return null;
        return list.get(list.size() - 1);
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        for (Map.Entry<K, List<V>> entry : this)
            if (entry.getValue().contains(value))
                return true;
        return false;
    }

    @Override
    public boolean containsValue(K key, V value) {
        if (!containsKey(key))
            return false;
        return map.get(key).contains(value);
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key))
            map.get(key).add(value);
        else {
            List<V> list = new LinkedList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    @Override
    public void putAll(K key, List<V> values) {
        if (containsKey(key))
            map.get(key).addAll(values);
        else map.put(key, new LinkedList<>(values));
    }

    @Override
    public boolean removeOne(K key, V value) {
        return map.get(key).remove(value);
    }

    @Override
    public int remove(K key, V value) {
        int rm = 0;
        List<V> list = map.get(key);
        while (list.contains(value)) {
            rm++;
            list.remove(value);
        }
        return rm;
    }

    @Override
    public List<V> removeAll(K key) {
        return map.remove(key);
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Set<Map.Entry<K, List<V>>> entrySet() {
        return map.entrySet();
    }

    @Override
    public Iterator<Map.Entry<K, List<V>>> iterator() {
        return entrySet().iterator();
    }
}
