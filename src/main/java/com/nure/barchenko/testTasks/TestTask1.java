package com.nure.barchenko.testTasks;


import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.ArrayList;
import java.util.List;

import static com.nure.barchenko.task1.Type.DIRECTED;

public class TestTask1 {
    public static void main(String[] args) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        Vertex<Integer> p1 = new Vertex<>(5,1);
        vertices.add(p1);
        Vertex<Integer> p2 = new Vertex<>(10,2);
        vertices.add(p2);
        Vertex<Integer> p3 = new Vertex<>(15,2);
        vertices.add(p3);

        List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        Edge<Integer> e1 = new Edge<>(1,p1,p2);
        edges.add(e1);
        Edge<Integer> e2 = new Edge<>(1,p2,p1);
        edges.add(e2);
        Edge<Integer> e3 = new Edge<>(2,p1,p2);
        edges.add(e3);
        Edge<Integer> e4 = new Edge<>(1,p3,p2);
        edges.add(e4);

        Graph<Integer> graph = new Graph<>(DIRECTED, vertices, edges);
        System.out.println(graph.toString());
    }
}
