package com.prohor.personal.stl.structures.graphs;

import com.prohor.personal.stl.structures.Counter;

import java.util.*;

public interface AbstractDigraph<T> extends AbstractGraph<T> {
    default boolean containsBidirectionalEdge(T firstVertex, T secondVertex) {
        return containsEdge(firstVertex, secondVertex) && containsEdge(secondVertex, firstVertex);
    }
    
    default List<T> topologicalSortingBasedDFS() {
        List<T> list = new LinkedList<>();
        LinkedList<T> stack = new LinkedList<>();
        Set<T> used = new HashSet<>();

        for (T current : getAllVertices()) {
            stack.addLast(current);
            while (!stack.isEmpty()) {
                T fromStack = stack.peekLast();
                if (used.contains(fromStack)) {
                    stack.pollLast();
                    if (!list.contains(fromStack)) {
                        list.add(0, fromStack);
                    }
                    continue;
                }
                used.add(fromStack);
                stack.addAll(getIncidentVertices(fromStack));
            }
        }
        return list;
    }

    default List<T> topologicalSortingByKahn() {
        List<T> list = new LinkedList<>();

        Counter<T> inDegreeCounter = new Counter<>();
        for (T t : getAllVertices()) inDegreeCounter.set(t, 0);
        for (T t : getAllVertices()) for(T tt : getIncidentVertices(t)) inDegreeCounter.increment(tt);

        int count = inDegreeCounter.size();
        while (!inDegreeCounter.isEmpty()) {
            for (Map.Entry<T, Integer> entry : inDegreeCounter.entrySet()) {
                if (entry.getValue() == 0) {
                    list.add(entry.getKey());
                    inDegreeCounter.remove(entry.getKey());
                    for (T incident : getIncidentVertices(entry.getKey())) {
                        inDegreeCounter.decrement(incident);
                    }
                    break;
                }
            }
            if (inDegreeCounter.size() == count) throw new RuntimeException("Graph has cycle");
            count = inDegreeCounter.size();
        }
        return list;
    }
}
