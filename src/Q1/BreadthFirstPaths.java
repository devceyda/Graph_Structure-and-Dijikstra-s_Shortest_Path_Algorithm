//-----------------------------------------------------
// Title: BreadthFirstPaths class
// Author: Ceyda Kuşçuoğlu

// Description: This class implements the breadth first search algorithm from the book
//-----------------------------------------------------
package Q1;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    int[] distTo;

    public BreadthFirstPaths(Graph G) {
        marked = new boolean[G.v()]; 
        edgeTo = new int[G.v()];
        distTo = new int[G.v()];
    }

    public int[] bfs(Graph G, int s) {
        ArrayQueue<Integer> q = new ArrayQueue<Integer>();
        q.add(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
        return distTo;
    }

}