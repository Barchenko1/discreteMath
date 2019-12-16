package com.nure.barchenko.task4;

import com.nure.barchenko.task1.CostPathPair;
import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.*;

public class Kruskal {

    public CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph) {
        int cost = 0;
        List<Edge<Integer>> path = new ArrayList<>();

        HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap = new HashMap<>();
        for (Vertex<Integer> v : graph.getVertices()) {
            HashSet<Vertex<Integer>> set = new HashSet<>();
            set.add(v);
            membershipMap.put(v, set);
        }

        PriorityQueue<Edge<Integer>> edgeQueue = new PriorityQueue<>(graph.getEdges());

        while (!edgeQueue.isEmpty()) {
            Edge<Integer> edge = edgeQueue.poll();

            if (!isTheSamePart(edge.getFromVertex(), edge.getToVertex(), membershipMap)) {
                union(edge.getFromVertex(), edge.getToVertex(), membershipMap);
                path.add(edge);
                cost += edge.getCost();
            }
        }
        return (new CostPathPair<>(cost, path));
    }

    private boolean isTheSamePart(Vertex<Integer> v1, Vertex<Integer> v2,
                                  HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap) {
        return membershipMap.get(v1) == membershipMap.get(v2);
    }

    private void union(Vertex<Integer> v1, Vertex<Integer> v2,
                       HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap) {
        HashSet<Vertex<Integer>> firstSet = membershipMap.get(v1);
        HashSet<Vertex<Integer>> secondSet = membershipMap.get(v2);

        if (secondSet.size() > firstSet.size()) {
            HashSet<Vertex<Integer>>  tempSet = firstSet;
            firstSet = secondSet;
            secondSet = tempSet;
        }
        for (Vertex<Integer> v : secondSet) {
            membershipMap.put(v, firstSet);
        }
        firstSet.addAll(secondSet);
    }
}
