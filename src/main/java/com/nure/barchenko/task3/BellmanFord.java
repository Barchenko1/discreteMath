package com.nure.barchenko.task3;

import com.nure.barchenko.task1.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public CostPathPair<Integer> getShortestPath(Graph<Integer> graph, Vertex<Integer> start, Vertex<Integer> end) {
        Map<Vertex<Integer>, List<Edge<Integer>>> paths = new HashMap<>();
        Map<Vertex<Integer>, CostVertexPair<Integer>> costs = new HashMap<>();
        return getShortestPath(graph, start, end, paths, costs);
    }

    private CostPathPair<Integer> getShortestPath(Graph<Integer> graph,
                                                  Vertex<Integer> start, Vertex<Integer> end,
                                                  Map<Vertex<Integer>, List<Edge<Integer>>> paths,
                                                  Map<Vertex<Integer>, CostVertexPair<Integer>> costs)
    {
        getShortestPath(graph, start, paths, costs);

        CostVertexPair<Integer> pair = costs.get(end);
        List<Edge<Integer>> list = paths.get(end);
        return (new CostPathPair<>(pair.getCost(), list));
    }

    private void getShortestPath(Graph<Integer> graph,
                                        Vertex<Integer> start,
                                        Map<Vertex<Integer>, List<Edge<Integer>>> paths,
                                        Map<Vertex<Integer>, CostVertexPair<Integer>> costs) {
        for (Vertex<Integer> v : graph.getVertices())
        {
            paths.put(v, new ArrayList<>());
        }

        for (Vertex<Integer> v : graph.getVertices())
            if (v.equals(start)) {
                costs.put(v, new CostVertexPair<>(0, v));
            } else {
                costs.put(v, new CostVertexPair<>(Integer.MAX_VALUE, v));
            }
        for (int i = 0; i < graph.getVertices().size(); i++) {
            for (Edge<Integer> e : graph.getEdges()) {
                CostVertexPair<Integer> pair = costs.get(e.getToVertex());
                CostVertexPair<Integer> lowestCostToThisVertex = costs.get(e.getFromVertex());

                if (lowestCostToThisVertex.getCost() == Integer.MAX_VALUE){
                    continue;
                }

                int cost = lowestCostToThisVertex.getCost() + e.getCost();
                if (cost < pair.getCost()) {
                    pair.setCost(cost);
                    List<Edge<Integer>> list = paths.get(e.getToVertex());
                    list.clear();
                    list.addAll(paths.get(e.getFromVertex()));
                    list.add(e);
                }
            }
        }
    }
}
