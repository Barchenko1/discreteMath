package com.nure.barchenko.testTasks;

import com.nure.barchenko.task1.CostPathPair;
import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;
import com.nure.barchenko.task3.BellmanFord;
import com.nure.barchenko.task3.Dijkstra;
import com.nure.barchenko.task3.FloydWarshall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nure.barchenko.task1.Type.DIRECTED;

public class TestTask3 {
    public static void main(String[] args) {
        TestTask3 testTask3 = new TestTask3();
        testTask3.testDijkstraDirected();
        testTask3.testDijkstraUndirected();
        testTask3.testBellmanFordUndirected();
        testTask3.testDijkstraDirectedWightNegativeWeights();
        testTask3.testBellmanFordDirected();
        testTask3.testFloydWarshallonDirectedWithNegWeights();
    }

    private void testDijkstraDirected() {
        DirectedGraph directed = new DirectedGraph();
        Graph<Integer> graph = directed.createDirectedGraph();
        Vertex<Integer> start = directed.v1;
        Vertex<Integer> end = directed.v6;
        Dijkstra dijkstra = new Dijkstra();
        CostPathPair<Integer> pair1 = dijkstra.getShortestPath(graph, start, end);
        System.out.println("Path from " + start.getValue() + " to " + end.getValue());
        System.out.println("Dijkstra's shortest path. pair="+pair1);
    }

    private void testDijkstraUndirected() {
        UndirectedGraph undirected = new UndirectedGraph();
        Graph<Integer> graph = undirected.createUndirectedGraph();
        System.out.println("G " +graph.height());
        Vertex<Integer> start = undirected.v1;
        Vertex<Integer> end = undirected.v5;
        Dijkstra dijkstra = new Dijkstra();
        CostPathPair<Integer> pair = dijkstra.getShortestPath(graph, start, end);
        System.out.println("Path from " + start.getValue() + " to " + end.getValue());
        System.out.println("Dijkstra's shortest path. pair="+pair);
    }

    private void testBellmanFordUndirected() {
        UndirectedGraph undirected = new UndirectedGraph();
        Graph<Integer> graph = undirected.createUndirectedGraph();
        Vertex<Integer> start = undirected.v1;
        Vertex<Integer> end = undirected.v5;
        BellmanFord bellmanFord = new BellmanFord();
        CostPathPair<Integer> pair = bellmanFord.getShortestPath(graph, start, end);
        System.out.println("Bellman-Ford's shortest path. pair="+pair);
    }

    private void testDijkstraDirectedWightNegativeWeights() {
        DirectedWithNegativeWeights directedWithNegWeights = new DirectedWithNegativeWeights();
        Graph<Integer> graph = directedWithNegWeights.createDirectedWithNegativeWeights();
        BellmanFord bellmanFord = new BellmanFord();
        Vertex<Integer> start = directedWithNegWeights.v1;
        Vertex<Integer> end = directedWithNegWeights.v3;
        CostPathPair<Integer> pair = bellmanFord.getShortestPath(graph, start, end);
        System.out.println("No path from " + start.getValue() + " to " + end.getValue());
        System.out.println("Bellman-Ford's shortest path. pair1="+pair);

    }

    private void testBellmanFordDirected() {
        DirectedGraph directed = new DirectedGraph();
        Graph<Integer> graph = directed.createDirectedGraph();
        Vertex<Integer> start = directed.v1;
        Vertex<Integer> end = directed.v5;
        BellmanFord bellmanFord = new BellmanFord();
        CostPathPair<Integer> pair = bellmanFord.getShortestPath(graph, start, end);
        System.out.println("No path from "+start.getValue()+" to "+end.getValue());
        System.out.println("Bellman-Ford's shortest path. pair2="+pair);
    }

    private void testFloydWarshallonDirectedWithNegWeights() {
        DirectedWithNegativeWeights directedWithNegWeights = new DirectedWithNegativeWeights();
        Graph<Integer> graph = directedWithNegWeights.createDirectedWithNegativeWeights();

        FloydWarshall floydWarshall = new FloydWarshall();
        Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> pathWeights = floydWarshall
                .getAllPairsShortestPaths(graph);
        for (Vertex<Integer> vertex1 : pathWeights.keySet()) {
            Map<Vertex<Integer>, Integer> m1 = pathWeights.get(vertex1);
            for (Vertex<Integer> v : m1.keySet()) {
                int i = m1.get(v);
                System.out.println("Floyd-Warshall's all-pairs shortest path weights. i= "+i + ", v= "+ v);
            }

        }

    }

}
