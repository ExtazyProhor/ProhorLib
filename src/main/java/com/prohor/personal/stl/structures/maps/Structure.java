package com.prohor.personal.stl.structures.maps;

public interface Structure<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    void clear();
}
