package com.nure.barchenko.task2;


import com.nure.barchenko.task1.Edge;
import com.nure.barchenko.task1.Graph;
import com.nure.barchenko.task1.Vertex;

import java.util.*;

public class BreadthFirstTraversal {

    public <T extends Comparable<T>> Vertex<T>[] breadthFirstTraversal(Graph<T> graph, Vertex<T> source) {
        ArrayList<Vertex<T>> vertices = new ArrayList<>(graph.getVertices());

        int n = vertices.size();
        Map<Vertex<T>,Integer> vertexToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Vertex<T> v = vertices.get(i);
            vertexToIndex.put(v,i);
        }

        byte[][] adj = new byte[n][n];
        for (Vertex<T> v : vertices) {
            int idx = vertexToIndex.get(v);
            byte[] array = new byte[n];
            adj[idx] = array;
            List<Edge<T>> edges = v.getEdges();
            for (Edge<T> e : edges)
                array[vertexToIndex.get(e.getToVertex())] = 1;
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        Vertex<T>[] arr = new Vertex[n];

        Vertex<T> element = source;
        int c = 0;
        int i = vertexToIndex.get(element); 
        int k = 0;

        arr[k] = element;
        visited[i] = 1;
        k++;

        Queue<Vertex<T>> queue = new ArrayDeque<Vertex<T>>();
        queue.add(source);
        while (!queue.isEmpty()) {    
            element = queue.peek();
            c = vertexToIndex.get(element);
            i = 0;
            while (i < n) {
                if (adj[c][i] == 1 && visited[i] == -1) {
                    Vertex<T> v = vertices.get(i);
                    queue.add(v);
                    visited[i] = 1;
                    arr[k] = v;
                    k++;
                }
                i++;
            }
            queue.poll();
        }
        return arr;
    }
}

