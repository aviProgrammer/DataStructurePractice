package com.example.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFS {

    private static int v;
    private Map<Integer, LinkedList<Integer>> graph;
    private LinkedList<Integer> adjset;

    private boolean[] visited;

    public BFS() {
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

    public void BFSUtil(int startVertex) {
        adjset.add(startVertex);
        while(!adjset.isEmpty()) {
            Integer currVertex = adjset.poll();
            if(!visited[currVertex]) {
                System.out.print(currVertex + "->");
                visited[currVertex] = true;
                for (Integer ajd: graph.get(currVertex)) {
                    if(!visited[ajd]) {
                        adjset.add(ajd);
                    }
                }
            }
        }
        adjset.clear();
    }

    public static void main(String[] args) {
        v=5;
        BFS gr = new BFS();

        gr.addEdge(0,1);
        gr.addEdge(0, 4);
        gr.addEdge(1, 4);
        gr.addEdge(1, 3);
        gr.addEdge(1,2);
        gr.addEdge(2,3);
        gr.addEdge(3,4);

        gr.BFSUtil(4);
    }
}
