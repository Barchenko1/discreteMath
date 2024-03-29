package com.nure.barchenko.task1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

    private T value;
    private int weight = 0;
    private List<Edge<T>> edges = new ArrayList<Edge<T>>();

    public Vertex(T value) {
        this.value = value;
    }

    public Vertex(T value, int weight) {
        this(value);
        this.weight = weight;
    }

    public Vertex(Vertex<T> vertex) {
        this(vertex.value, vertex.weight);
        this.edges.addAll(vertex.edges);
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addEdge(Edge<T> e) {
        edges.add(e);
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public Edge<T> getEdge(Vertex<T> v) {
        for (Edge<T> e : edges) {
            if (e.getToVertex().equals(v))
                return e;
        }
        return null;
    }

    public boolean pathTo(Vertex<T> v) {
        for (Edge<T> e : edges) {
            if (e.getToVertex().equals(v))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Vertex<T> v) {
        final int valueComp = this.value.compareTo(v.value);
        if (valueComp != 0)
            return valueComp;

        if (this.weight < v.weight)
            return -1;
        if (this.weight > v.weight)
            return 1;

        if (this.edges.size() < v.edges.size())
            return -1;
        if (this.edges.size() > v.edges.size())
            return 1;

        final Iterator<Edge<T>> iter1 = this.edges.iterator();
        final Iterator<Edge<T>> iter2 = v.edges.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            final Edge<T> e1 = iter1.next();
            final Edge<T> e2 = iter2.next();
            if (e1.getCost() < e2.getCost())
                return -1;
            if (e1.getCost() > e2.getCost())
                return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Value=").append(value).append(" weight=").append(weight).append("\n");
        for (Edge<T> e : edges)
            builder.append("\t").append(e.toString());
        return builder.toString();
    }
}