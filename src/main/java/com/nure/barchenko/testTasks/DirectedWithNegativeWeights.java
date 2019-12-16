package com.nure.barchenko.testTasks;

import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.ArrayList;
import java.util.List;

import static com.nure.barchenko.task1.Type.DIRECTED;

public class DirectedWithNegativeWeights {
    Vertex<Integer> v1 = new Vertex<Integer>(1);
    Vertex<Integer> v2 = new Vertex<Integer>(2);
    Vertex<Integer> v3 = new Vertex<Integer>(3);
    Vertex<Integer> v4 = new Vertex<Integer>(4);

    Edge<Integer> e1_4 = new Edge<Integer>(2, v1, v4);
    Edge<Integer> e2_1 = new Edge<Integer>(6, v2, v1);
    Edge<Integer> e2_3 = new Edge<Integer>(3, v2, v3);
    Edge<Integer> e3_1 = new Edge<Integer>(4, v3, v1);
    Edge<Integer> e3_4 = new Edge<Integer>(5, v3, v4);
    Edge<Integer> e4_2 = new Edge<Integer>(-7, v4, v2);
    Edge<Integer> e4_3 = new Edge<Integer>(-3, v4, v3);

    public Graph<Integer> createDirectedWithNegativeWeights(){
        List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();

        verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);

        List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();


        edges.add(e1_4);
        edges.add(e2_1);
        edges.add(e2_3);
        edges.add(e3_1);
        edges.add(e3_4);
        edges.add(e4_2);
        edges.add(e4_3);

        return new Graph<Integer>(DIRECTED, verticies, edges);
    }

}
