package Q3;


public class Main {
        public static void main(String[] args) throws Exception {

        // Scanner scanner = new Scanner(System.in);
        // int M = scanner.nextInt(); // Museum count
        // int N = scanner.nextInt(); // Road count

        // Graph graph = new Graph(M);

        // for (int i = 0; i < N; i++) {
        //     int U = scanner.nextInt();
        //     int V = scanner.nextInt();
        //     int weight = scanner.nextInt(); // Read the weight (time) of the edge
        //     graph.addEdge(U, V, weight);
        // }

        int V = 4; // Number of vertices
        int[][] adjacencyMatrix = new int[V][V];

        // Initialize the adjacency matrix with zeros
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        // Define the edges and distances
        int[][] edges = {
            {0, 1, 1},
            {1, 2, 2},
            {1, 3, 3}
        };

        // Populate the adjacency matrix with edges and distances
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];
            adjacencyMatrix[u][v] = distance;
            adjacencyMatrix[v][u] = distance; // For undirected graph, set the reverse edge
        }
        ShortestPath sp= new ShortestPath();
        sp.dijkstra(adjacencyMatrix, 2);
        // for (int i = 0; i < 4; i++) {
            
        //     sp.dijkstra(adjacencyMatrix, i);
        // }

    }

}
