package com.prohor.personal.stl.util;

import java.util.Iterator;

public class Range {
    public static Iterable<Integer> range(int to) {
        return range(0, to);
    }

    public static Iterable<Integer> range(int from, int to) {
        return range(from, to, 1);
    }

    public static Iterable<Integer> range(int from, int to, int step) {
        if (step == 0)
            throw new RuntimeException("step must not be 0");
        if (step > 0) {
            return () -> new Iterator<>() {
                int cursor = from;

                public boolean hasNext() {
                    return cursor < to;
                }

                public Integer next() {
                    cursor += step;
                    return cursor - step;
                }
            };
        }
        return () -> new Iterator<>() {
            int cursor = from;

            public boolean hasNext() {
                return cursor > to;
            }

            public Integer next() {
                cursor += step;
                return cursor - step;
            }
        };
    }
}
