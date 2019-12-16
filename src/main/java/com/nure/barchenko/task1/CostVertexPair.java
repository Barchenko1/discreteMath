package com.nure.barchenko.task1;

public class CostVertexPair<T extends Comparable<T>> implements Comparable<CostVertexPair<T>> {

    private int cost;
    private Vertex<T> vertex;

    public CostVertexPair(int cost, Vertex<T> vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(CostVertexPair<T> p) {
        return Integer.compare(this.cost, p.getCost());
    }

    @Override
    public String toString() {
        return vertex.getValue() + " (" + vertex.getWeight() + ") " + " cost=" + cost + "\n";
    }
}