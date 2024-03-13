//-----------------------------------------------------
// Title: Graph implementation class
// Author: Ceyda Kuşçuoğlu

// Description: This class implements the graph api
//-----------------------------------------------------
package Q2;

public class Graph {
    private final int V;
    private Bag<Integer>[] adj;
    private int[][] edgeWeights; //this matrix holds the weight of edges

    public Graph(int V) { //initialize the graph
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        edgeWeights = new int[V][V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public void addEdge(int v, int w, int weight) {
        adj[v - 1].add(w - 1);
        adj[w - 1].add(v - 1);
        edgeWeights[v - 1][w - 1] = weight;
        edgeWeights[w - 1][v - 1] = weight;
    }

    public int getEdgeWeight(int v, int w) {
        return edgeWeights[v][w];
    }

    public void removeEdge(int v, int w) {
        adj[v].remove(w);
        adj[w].remove(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }
}
