import java.io.*;
import java.util.*;

public class BellManFord_ShortestPath {

    public static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }


        public long nextLong() {
            return Long.parseLong(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


        public String nextLine() {
            st = null;

            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }


    public static void printArr(int [] dist, int V){
        System.out.println("Vertex  Distance from Source\n");
        for(int i=0;i<V;i++)
            System.out.println(i+"\t"+dist[i]);
    }

    /**
     * Finds the shortest distances from src to all other vertices using Bellman-Ford algorithm. also detects
     * negative weight cycle
     * @param graph
     * @param src
     */

    public static void BellManFord(Graph graph,int src){

        int V = graph.V;
        int E = graph.E;

        int [] dist = new int [V];

        // Step 1: Initialize distances from src to all other vertices as Infinite
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        // Step 2: Relax all edges [V]-1 times. A simple shortest path from src to any other vertices  can have
        // at most [V] - 1 edges

        for(int i=1;i <= V -1;i++){
            for(int j=0; j<E;j++){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;

            }
        }

        // Step 3: Check for negative weight cycles . Above step guarantee shortest distances if graph doesn't
        // contain negative weight cycle

        for (int i=0;i<E;i++){
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int weight = graph.edge[i].weight;

            if (dist[u] !=Integer.MAX_VALUE && dist[u] + weight < dist[v])
                System.out.println("Graph contains negative weight cycle");
        }

        printArr(dist,V);


    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();// vertices
        int m = in.nextInt(); // edges

        Graph graph = new Graph(n,m);



        for(int i=0;i<m;i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            int weight = in.nextInt();
            Edge eg = new Edge(src,dest,weight);
            graph.edge[i] = eg;

        }
        // Graph is created

        BellManFord(graph,0);


    }

}