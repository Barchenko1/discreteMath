package com.nure.barchenko.testTasks;

import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;
import com.nure.barchenko.task2.BreadthFirstTraversal;
import com.nure.barchenko.task2.DepthFirstTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nure.barchenko.task1.Type.DIRECTED;

public class TestTask2 {
    public static void main(String[] args) {
        BreadthFirstTraversal breadthFirstTraversal = new BreadthFirstTraversal();
        List<Vertex<Integer>> vertices = new ArrayList<>();
        List<Edge<Integer>> edges = new ArrayList<>();

        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        edges.add(new Edge<>(0, v0, v1));
        edges.add(new Edge<>(0, v0, v2));
        edges.add(new Edge<>(0, v1, v2));
        edges.add(new Edge<>(0, v2, v0));
        edges.add(new Edge<>(0, v2, v3));

        Graph<Integer> graph = new Graph<>(DIRECTED, vertices, edges);
        Vertex<Integer>[] result1 = breadthFirstTraversal.breadthFirstTraversal(graph, v2);
        System.out.println(Arrays.toString(result1));

        DepthFirstTraversal depthFirstTraversal = new DepthFirstTraversal();
        Vertex<Integer>[] result2 = depthFirstTraversal.depthFirstTraversal(graph, v2);
        System.out.println(Arrays.toString(result2));

    }
}
