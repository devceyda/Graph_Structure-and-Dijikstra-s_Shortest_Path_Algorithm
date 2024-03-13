//-----------------------------------------------------
// Title: Graph implementation class
// Author: Ceyda Kuşçuoğlu

// Description: This class implements the graph api
//-----------------------------------------------------
package Q1;
import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int V; //number of vertex
    private Bag<Integer>[] adj; //holds the adjacents of the vertex


    public Graph(int V) {  //initialize the graph
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void removeEdge(int v, int w) {
        adj[v].remove(w);
        adj[w].remove(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int v() {
        return this.V;
    }

    public List<List<Integer>> addNewWay(Graph g, int start, int end) {  
        //This method takes the graph and for adding new way between vertices takes the start and end vertex
        //this method returns the list of new railways
        BreadthFirstPaths bfso = new BreadthFirstPaths(g);
        int[] distTo = bfso.bfs(g, start);
        int distance = distTo[end] - distTo[start];
        Bag<Integer> adjList;

        List<List<Integer>> newTracks = new ArrayList<>();  //this list holds the list of new railways,inside list it keeps the vertices of railway

        for (int i = 0; i < g.v(); i++) {
            adjList = (Bag<Integer>) g.adj(i);
            for (int j = 1; j < g.v(); j++) {
                if (!adjList.contains(j) && i != j) {
                    g.addEdge(i, j);
                    bfso = new BreadthFirstPaths(g);
                    distTo = bfso.bfs(g, start);
                    int newDistance = distTo[end] - distTo[start];
                    if (distance != (newDistance) && distance > (newDistance)) {
                        //if new railway reduces the distance this method removes it
                        g.removeEdge(i, j);
                    } else {
                        //else it adds the new railway to tha graph
                        List<Integer> a = new ArrayList<>();
                        a.add(i);
                        a.add(j);
                        newTracks.add(a);
                    }

                }
            }
        }

        return newTracks;

    }

}