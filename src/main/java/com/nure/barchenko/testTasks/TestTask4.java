package com.nure.barchenko.testTasks;

import com.nure.barchenko.task1.CostPathPair;
import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;
import com.nure.barchenko.task4.Kruskal;
import com.nure.barchenko.task4.Prim;

import java.util.ArrayList;
import java.util.List;

import static com.nure.barchenko.task1.Type.UNDIRECTED;

public class TestTask4 {
    public static void main(String[] args) {
        TestTask4 testTask4 = new TestTask4();
        testTask4.testKruskalUndirected();
        testTask4.testPrimUndirected();
    }

    private Graph<Integer> createCyclicVertices()
    {
        List<Vertex<Integer>> cyclicVertices = new ArrayList<Vertex<Integer>>();
        Vertex<Integer> cv1 = new Vertex<Integer>(1);
        Vertex<Integer> cv2 = new Vertex<Integer>(2);
        Vertex<Integer> cv3 = new Vertex<Integer>(3);
        Vertex<Integer> cv4 = new Vertex<Integer>(4);
        Vertex<Integer> cv5 = new Vertex<Integer>(5);
        cyclicVertices.add(cv1);
        cyclicVertices.add(cv2);
        cyclicVertices.add(cv3);
        cyclicVertices.add(cv4);
        cyclicVertices.add(cv5);

        List<Edge<Integer>> cyclicEdges = new ArrayList<Edge<Integer>>();
        Edge<Integer> ce1_2 = new Edge<Integer>(3, cv1, cv2);
        Edge<Integer> ce2_3 = new Edge<Integer>(2, cv2, cv3);
        Edge<Integer> ce3_4 = new Edge<Integer>(4, cv3, cv4);
        Edge<Integer> ce4_1 = new Edge<Integer>(1, cv4, cv1);
        Edge<Integer> ce4_5 = new Edge<Integer>(1, cv4, cv5);

        cyclicEdges.add(ce1_2);
        cyclicEdges.add(ce2_3);
        cyclicEdges.add(ce3_4);
        cyclicEdges.add(ce4_1);
        cyclicEdges.add(ce4_5);
        return new Graph<>(UNDIRECTED, cyclicVertices, cyclicEdges);
    }

    private void testKruskalUndirected() {
        final UndirectedGraph undirected = new UndirectedGraph();
        Graph<Integer> graph = undirected.createUndirectedGraph();
        {
        Kruskal kruskal = new Kruskal();
        CostPathPair<Integer> resultMST = kruskal.getMinimumSpanningTree(graph);
        System.out.println("Kruskal's minimum spanning tree. resultMST=" + resultMST);

        Graph<Integer> cyclicUndirected = createCyclicVertices();
        CostPathPair<Integer> pair = kruskal.getMinimumSpanningTree(cyclicUndirected);
        System.out.println("Kruskal's minimum spanning tree. pair=" + pair);

        }
    }

    public void testPrimUndirected() {
        UndirectedGraph undirected = new UndirectedGraph();
        Graph<Integer> graph = undirected.createUndirectedGraph();
        Vertex<Integer> start = undirected.v1;
        Prim prim = new Prim();
        CostPathPair<Integer> resultMST = prim.getMinimumSpanningTree(graph, start);
        System.out.println("Prim's minimum spanning tree. resultMST="+resultMST);
    }
}
