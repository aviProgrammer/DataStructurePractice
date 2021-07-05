package com.example.datastructure;

import java.util.*;

public class Graph {

    private static int v;
    Map<Integer, HashSet<Integer>> graph;

    public Graph() {
        v=5;
        graph = new HashMap<>();

        for (int i = 0; i < v; i++) {
            graph.put(i, new HashSet<>());
        }
    }

    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    public void printGraph() {


        for (int i = 0; i < v; i++) {
            System.out.print(i + "->");

            for(int adj : graph.get(i)) {
                System.out.print(adj + "->");
            }
            System.out.print("null");
            System.out.println();
        }
    }


    public static void main(String[] args) {

        v=5;
        Graph gr = new Graph();

        gr.addEdge(0,1);
        gr.addEdge(0, 4);
        gr.addEdge(1, 4);
        gr.addEdge(1, 3);
        gr.addEdge(1,2);
        gr.addEdge(2,3);
        gr.addEdge(3,4);

        gr.printGraph();

    }

}
