package com.prohor.personal.stl.structures.maps;

import java.util.*;

public interface MultiMap<K,V> extends Structure<Map.Entry<K, List<V>>> {
    List<V> getAll(K key);

    V getFirst(K key);

    V getLast(K key);

    boolean containsKey(K key);

    boolean containsValue(K key, V value);

    boolean containsValue(V value);

    void put(K key, V value);

    void putAll(K key, List<V> values);

    boolean removeOne(K key, V value);

    int remove(K key, V value);

    List<V> removeAll(K key);

    Set<K> keySet();

    Set<Map.Entry<K, List<V>>> entrySet();
}
