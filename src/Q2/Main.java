//-----------------------------------------------------
// Title: Main implementation class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the main method
//-----------------------------------------------------

package Q2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int museumNumber = scanner.nextInt(); 
        int edgeNumber = scanner.nextInt(); 

        Graph graph = new Graph(museumNumber); //initialize the graph

        for (int i = 0; i < edgeNumber; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(v, w, weight);
        }

        int minTime = Integer.MAX_VALUE;
        int theFirstMuseumOfThePath  = -5;

        for (int museum = 0; museum < museumNumber; museum++) { //this for loop try every vertex of the start vertex and takes the minimum time
            DepthFirstPaths dfs = new DepthFirstPaths(graph, museum);
            int time = dfs.getMinTime();
            if (time <= minTime) {
                minTime = time;
                theFirstMuseumOfThePath = museum;
            }
        }
        
        if (minTime == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minTime);
        }
        //this part prints the order of the dfs algorithm
        DepthFirstPaths dfs1 = new DepthFirstPaths(graph, theFirstMuseumOfThePath);
        dfs1.print(graph, theFirstMuseumOfThePath);
        System.out.println();

    }

}
