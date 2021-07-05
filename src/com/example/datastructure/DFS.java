package com.example.datastructure;

import java.util.*;

public class DFS {

    private static int v;
    private Map<Integer, LinkedList<Integer>> graph;
    private LinkedList<Integer> adjset;

    private boolean[] visited;

    public DFS() {
        v=5;
        graph = new HashMap<>();
        adjset = new LinkedList<>();
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            graph.put(i, new LinkedList<>());
            visited[i] = false;
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

    public void DFSUtilIterative(int startVertex) {
        adjset.add(startVertex);
        while(!adjset.isEmpty()) {
            Integer currVertex = adjset.removeLast();
            if(!visited[currVertex]) {
                System.out.print(currVertex + "->");
                adjset.addAll(graph.get(currVertex));
                visited[currVertex]=true;
            }
        }
        adjset.clear();
    }

    public void DFSUtilRecursive(int vtx, boolean[] visited) {
        if (!visited[vtx]) {
            System.out.print(vtx + "->");
            visited[vtx] = true;
            for (Integer adj: graph.get(vtx)) {
                DFSUtilRecursive(adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        v=4;
        DFS g = new DFS();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Iterative DFS");
        g.DFSUtilIterative(2);

        for (int i = 0; i < v; i++) {
            g.visited[i] = false;
        }
        System.out.println();
        System.out.println("Recursive DFS");
        g.DFSUtilRecursive(2, g.visited);
    }
}
