package com.nure.barchenko.task1;

import java.util.List;

public class CostPathPair<T extends Comparable<T>> {

    private int cost = 0;
    private List<Edge<T>> path = null;

    public CostPathPair(int cost, List<Edge<T>> path) {
        this.cost = cost;
        this.path = path;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Edge<T>> getPath() {
        return path;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Cost = ").append(cost).append("\n");
        for (Edge<T> e : path)
            builder.append("\t").append(e);
        return builder.toString();
    }
}