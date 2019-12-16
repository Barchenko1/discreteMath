package com.nure.barchenko.testTasks;

import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.ArrayList;
import java.util.List;

import static com.nure.barchenko.task1.Type.DIRECTED;

public class DirectedGraph {

    Vertex<Integer> v1 = new Vertex<Integer>(1);
    Vertex<Integer> v2 = new Vertex<Integer>(2);
    Vertex<Integer> v3 = new Vertex<Integer>(3);
    Vertex<Integer> v4 = new Vertex<Integer>(4);
    Vertex<Integer> v5 = new Vertex<Integer>(5);
    Vertex<Integer> v6 = new Vertex<Integer>(6);
    Vertex<Integer> v7 = new Vertex<Integer>(7);
    Vertex<Integer> v8 = new Vertex<Integer>(8);

    Edge<Integer> e1_2 = new Edge<Integer>(7, v1, v2);
    Edge<Integer> e1_3 = new Edge<Integer>(9, v1, v3);
    Edge<Integer> e1_6 = new Edge<Integer>(14, v1, v6);
    Edge<Integer> e2_3 = new Edge<Integer>(10, v2, v3);
    Edge<Integer> e2_4 = new Edge<Integer>(15, v2, v4);
    Edge<Integer> e3_4 = new Edge<Integer>(11, v3, v4);
    Edge<Integer> e3_6 = new Edge<Integer>(2, v3, v6);
    Edge<Integer> e6_5 = new Edge<Integer>(9, v6, v5);
    Edge<Integer> e6_8 = new Edge<Integer>(14, v6, v8);
    Edge<Integer> e4_5 = new Edge<Integer>(6, v4, v5);
    Edge<Integer> e4_7 = new Edge<Integer>(16, v4, v7);
    Edge<Integer> e1_8 = new Edge<Integer>(30, v1, v8);

    public Graph<Integer> createDirectedGraph()
    {
        List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();

        verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);
        verticies.add(v5);
        verticies.add(v6);
        verticies.add(v7);
        verticies.add(v8);

        List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();

        edges.add(e1_2);
        edges.add(e1_3);
        edges.add(e1_6);
        edges.add(e2_3);
        edges.add(e2_4);
        edges.add(e3_4);
        edges.add(e3_6);
        edges.add(e6_5);
        edges.add(e6_8);
        edges.add(e4_5);
        edges.add(e4_7);
        edges.add(e1_8);

        return new Graph<>(DIRECTED, verticies, edges);
    }

}