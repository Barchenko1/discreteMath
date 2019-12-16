package com.nure.barchenko.task3;



import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloydWarshall {

    public Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> getAllPairsShortestPaths(Graph<Integer> graph) {
        List<Vertex<Integer>> vertices = graph.getVertices();
        int[][] sums = new int[vertices.size()][vertices.size()];
        for (int[] sum : sums) {
            Arrays.fill(sum, Integer.MAX_VALUE);
        }

        List<Edge<Integer>> edges = graph.getEdges();
        for (Edge<Integer> e : edges) {
            int indexOfFrom = vertices.indexOf(e.getFromVertex());
            int indexOfTo = vertices.indexOf(e.getToVertex());
            sums[indexOfFrom][indexOfTo] = e.getCost();
        }

        for (int k = 0; k < vertices.size(); k++) {
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    if (i == j) {
                        sums[i][j] = 0;
                    } else {
                        int ijCost = sums[i][j];
                        int ikCost = sums[i][k];
                        int kjCost = sums[k][j];
                        int summed = (ikCost != Integer.MAX_VALUE &&
                                            kjCost != Integer.MAX_VALUE) ? (ikCost + kjCost) : Integer.MAX_VALUE;
                        if (ijCost > summed)
                            sums[i][j] = summed;
                    }
                }
            }
        }

        Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> allShortestPaths = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums[i].length; j++) {
                Vertex<Integer> from = vertices.get(i);
                Vertex<Integer> to = vertices.get(j);

                Map<Vertex<Integer>, Integer> map = allShortestPaths.get(from);
                if (map == null) {
                    map = new HashMap<>();
                }
                int cost = sums[i][j];
                if (cost != Integer.MAX_VALUE)
                    map.put(to, cost);
                allShortestPaths.put(from, map);
            }
        }
        return allShortestPaths;
    }
}
