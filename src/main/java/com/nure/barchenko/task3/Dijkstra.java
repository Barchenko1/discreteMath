package com.nure.barchenko.task3;


import com.nure.barchenko.task1.*;

import java.util.*;

public class Dijkstra {
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
        for (Vertex<Integer> v : graph.getVertices())
        {
            paths.put(v, new ArrayList<>());
        }

        for (Vertex<Integer> v : graph.getVertices()) {
            if (v.equals(start)) {
                costs.put(v, new CostVertexPair<>(0, v));
            }else{
                costs.put(v, new CostVertexPair<>(Integer.MAX_VALUE, v));
            }
        }

        Queue<CostVertexPair<Integer>> unvisited = new PriorityQueue<>();
        unvisited.add(costs.get(start));

        while (!unvisited.isEmpty()) {
            CostVertexPair<Integer> pair = unvisited.remove();
            Vertex<Integer> vertex = pair.getVertex();

            for (Edge<Integer> e : vertex.getEdges()) {
                CostVertexPair<Integer> toPair = costs.get(e.getToVertex());
                CostVertexPair<Integer> lowestCostToThisVertex = costs.get(vertex);
                int cost = lowestCostToThisVertex.getCost() + e.getCost();
                if (toPair.getCost() == Integer.MAX_VALUE) {

                    unvisited.remove(toPair);
                    toPair.setCost(cost);
                    unvisited.add(toPair);

                    List<Edge<Integer>> set = paths.get(e.getToVertex());
                    set.addAll(paths.get(e.getFromVertex()));
                    set.add(e);
                } else if (cost < toPair.getCost()) {

                    unvisited.remove(toPair);
                    toPair.setCost(cost);
                    unvisited.add(toPair);

                    List<Edge<Integer>> set = paths.get(e.getToVertex());
                    set.clear();
                    set.addAll(paths.get(e.getFromVertex()));
                    set.add(e);
                }
            }
            if (vertex.equals(end)) {
                break;
            }
        }
        if (end != null) {
            CostVertexPair<Integer> pair = costs.get(end);
            List<Edge<Integer>> set = paths.get(end);
            return (new CostPathPair<>(pair.getCost(), set));
        }
        return null;
    }
}
