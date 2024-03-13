//-----------------------------------------------------
// Title: Main implementation class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the main method
//-----------------------------------------------------

package Q1;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int vertexNumber = scan.nextInt();
        int edgeNumber = scan.nextInt();
        int startVertex = scan.nextInt();
        int endVertex = scan.nextInt();

        Graph g = new Graph(vertexNumber); //initialize the graph with given vertex number

        for (int i = 0; i < edgeNumber; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            g.addEdge(a-1, b-1);
        }

        List<List<Integer>> a = g.addNewWay(g, startVertex - 1, endVertex - 1); //takes the new railways of the graph

        if (a.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(a.size());
            for (List<Integer> index : a) {
                for (Integer element : index) {
                    System.out.print((element + 1) + " ");
                }
                System.out.println();
            }
        }
     
    }
}
