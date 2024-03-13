package Q3;

import java.util.*;

class Graph {
    private int V;
    private List<Edge>[] adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int weight) {
        Edge edge = new Edge(u, v, weight);
        adjList[u].add(edge);
        adjList[v].add(edge); // For an undirected graph
    }

    public void minimumSpanningTree() {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        boolean[] visited = new boolean[V];
        int totalWeight = 0;
    
        // Start with the first vertex
        visited[0] = true;
        for (Edge edge : adjList[0]) {
            minHeap.add(edge);
        }
    
        System.out.println("Minimum Spanning Tree (MST):");
    
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
    
            if (visited[u] && visited[v]) {
                totalWeight += weight;
                continue; // Skip if both vertices are already visited (backtracking)
            }
    
            visited[u] = true;
            visited[v] = true;
    
            System.out.println(u + " - " + v + " : " + weight);
            totalWeight += weight; // Update the total weight
    
            // Add unvisited neighboring edges
            for (Edge nextEdge : adjList[v]) {
                if (!visited[nextEdge.v]) {
                    minHeap.add(nextEdge);
                }
            }
        }
    
        System.out.println("Total MST Weight: " + totalWeight); // Print the total weight
    }
    
    

    private static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        Graph graph = new Graph(V);

        // Add edges with weights
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 2, 2);
       

        graph.minimumSpanningTree();
    }


}