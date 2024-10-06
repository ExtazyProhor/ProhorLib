package com.prohor.personal.stl.structures.graphs;

public class Graph<T> extends AbstractUnweightedGraph<T> {
    public Graph() {
        super();
    }

    @Override
    public void addEdge(T firstVertex, T secondVertex) {
        addVerticesIfNotExists(firstVertex, secondVertex);
        adjacencyList.get(firstVertex).add(secondVertex);
        adjacencyList.get(secondVertex).add(firstVertex);
    }
}
