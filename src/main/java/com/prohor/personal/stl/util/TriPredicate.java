package com.prohor.personal.stl.util;

@FunctionalInterface
public interface TriPredicate<T, U, V> {
    boolean check(T t, U u, V v);
}
