//-----------------------------------------------------
// Title: Depth First Paths class
// Author: Ceyda Kuşçuoğlu

// Description: This class implements the depth first search algorithm from the book
//-----------------------------------------------------
package Q2;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    private int totalTime; // total time spent visiting museums
    private int visitedMuseumNumber; // if all the museums have been visited or not

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        totalTime = 0;
        visitedMuseumNumber = 0;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        visitedMuseumNumber++;
        for (int w : G.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                totalTime += G.getEdgeWeight(v, w); // Adds the time for the visited edge to total time

                dfs(G, w);
                if (visitedMuseumNumber < G.V()) {
                    totalTime += G.getEdgeWeight(v, w); // Adds the backtracking time to total time

                }
            }

    }

    public void print(Graph G, int v) { // initialize the structure and prints the dfs order
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        totalTime = 0;
        visitedMuseumNumber = 0;
        printDfs(G, v);
    }

    private void printDfs(Graph G, int v) { // Applys the dfs starting from the given vertex
        marked[v] = true;
        visitedMuseumNumber++;
        System.out.print((v + 1) + " ");
        for (int w : G.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                totalTime += G.getEdgeWeight(v, w);

                printDfs(G, w);
                if (visitedMuseumNumber < G.V()) {
                    totalTime += G.getEdgeWeight(v, w);
                    System.out.print((v + 1) + " ");

                }
            }

    }

    public int getMinTime() {
        return totalTime;
    }

}
