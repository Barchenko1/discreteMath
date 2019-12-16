package com.nure.barchenko.task1;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

    private Vertex<T> from;
    private Vertex<T> to;
    private int cost;

    public Edge(int cost, Vertex<T> from, Vertex<T> to) {
        this.cost = cost;
        this.from = from;
        this.to = to;
    }

    public Edge(Edge<T> e) {
        this(e.cost, e.from, e.to);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex<T> getFromVertex() {
        return from;
    }

    public Vertex<T> getToVertex() {
        return to;
    }

    @Override
    public int compareTo(Edge<T> e) {
        if (this.cost < e.cost)
            return -1;
        if (this.cost > e.cost)
            return 1;

        final int from = this.from.compareTo(e.from);
        if (from != 0)
            return from;

        return this.to.compareTo(e.to);
    }

    @Override
    public String toString() {
        return "[ " + from.getValue() + "(" + from.getWeight() + ") " + "]" + " -> " +
                "[ " + to.getValue() + "(" + to.getWeight() + ") " + "]" + " = " + cost + "\n";
    }
}