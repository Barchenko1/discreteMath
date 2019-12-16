package com.nure.barchenko.task1;

import java.util.*;

import static com.nure.barchenko.task1.Type.UNDIRECTED;

public class Graph<T extends Comparable<T>> {

    private List<Vertex<T>> allVertices = new ArrayList<Vertex<T>>();
    private List<Edge<T>> allEdges = new ArrayList<Edge<T>>();
    private Type type;

    public Graph(Type type) {
        this.type = type;
    }

    public Graph(Graph<T> g) {
        type = g.getType();

        for (Vertex<T> v : g.getVertices())
            this.allVertices.add(new Vertex<T>(v));

        for (Vertex<T> v : this.getVertices()) {
            this.allEdges.addAll(v.getEdges());
        }
    }

    public Graph(Collection<Vertex<T>> vertices, Collection<Edge<T>> edges) {
        this(UNDIRECTED, vertices, edges);
    }

    public void removeVertices(Vertex<T> vertex){
        this.allVertices.remove(vertex);
    }

    public boolean findVertex(Vertex<T> v)
    {
        for (Vertex<T> element: allVertices) {
            if (element.equals(v)){
                return true;
            }
        }
        return false;
    }

    public Graph(Type type, Collection<Vertex<T>> vertices, Collection<Edge<T>> edges) {
        this(type);

        this.allVertices.addAll(vertices);
        this.allEdges.addAll(edges);

        for (Edge<T> e : edges) {
            Vertex<T> from = e.getFromVertex();
            Vertex<T> to = e.getToVertex();

            if (!this.allVertices.contains(from) || !this.allVertices.contains(to))
                continue;

            from.addEdge(e);
            if (this.type == UNDIRECTED) {
                Edge<T> reciprical = new Edge<T>(e.getCost(), to, from);
                to.addEdge(reciprical);
                this.allEdges.add(reciprical);
            }
        }
    }

    public int height()
    {
        return (int) Math.round(Math.log(allVertices.size()) + 1);
    }

    public Type getType() {
        return type;
    }

    public List<Vertex<T>> getVertices() {
        return allVertices;
    }

    public List<Edge<T>> getEdges() {
        return allEdges;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Vertex<T> v : allVertices)
            builder.append(v.toString());
        return builder.toString();
    }

}