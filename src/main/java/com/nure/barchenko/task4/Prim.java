package com.nure.barchenko.task4;

import com.nure.barchenko.task1.CostPathPair;
import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.*;

public class Prim {

    public CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph, Vertex<Integer> start) {
        int cost = 0;

        Set<Vertex<Integer>> unvisited = new HashSet<>(graph.getVertices());
        unvisited.remove(start);

        List<Edge<Integer>> path = new ArrayList<>();
        Queue<Edge<Integer>> edgesAvailable = new PriorityQueue<>();

        Vertex<Integer> vertex = start;
        while (!unvisited.isEmpty()) {

            for (Edge<Integer> e : vertex.getEdges()) {
                if (unvisited.contains(e.getToVertex()))
                    edgesAvailable.add(e);
            }

            Edge<Integer> e = edgesAvailable.remove();
            cost += e.getCost();
            path.add(e);

            vertex = e.getToVertex();
            unvisited.remove(vertex);
        }

        return (new CostPathPair<>(cost, path));
    }
}
