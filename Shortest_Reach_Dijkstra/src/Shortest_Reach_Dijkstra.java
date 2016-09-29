/**
 * Created by NIslam on 9/18/16.
 */

import java.util.*;
import java.io.*;
import java.lang.*;


class subset {
    int parent;
    int rank;
}


class Edge implements Comparable<Edge>{

    public int src;
    public int dest;
    public int weight;

    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }

}


class Graph {
    public int V,E;
    Edge [] edge;

    //Edge edge = new Edge[];

    Graph(int v, int e){
        V=v;
        E=e;

        edge = new Edge[E];
        for (int i=0;i<E;i++){
            edge[i] = new Edge();
        }

    }

    public void printArr(int [] dist){
        System.out.println("Vertex      distance from source ");
        for(int i=0;i<dist.length;i++)
            System.out.println(i+"\t\t"+dist[i]);
    }


    // The main function that finds shortest distance from src
    // to all other vertices using Bellman ford algorithm
    // The algo also detects negative weight cycle

    public void BellmanFord(Graph graph , int src) {

        // else discard the next edge if they are the same
        int V = graph.V;
        int E = graph.E;
        int [] dist= new int [V];

        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        //Mark the source vextex value as 0
        dist[src] = 0;

        /*
        Relax all edges [v] -1 times . A simple shortest path
        from src to any other vertex can have at most [V] -1 edges
        */

        for(int i=1;i<V;i++){
            for(int j=0;j<E;j++){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;


                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                }

            }
        }

        /*
        Check for negative weight cycles. The above step guarantees
        shortest distances if graph does not contain negative
        weight cycle. if there is a shorter path , then there
        is a cycle

         */

        printArr(dist);

        for(int j=0;j<E;j++){
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;

            int weight = graph.edge[j].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                System.out.println("The Graph contains negative weight cycle");
            }
        }

    }

}

class Scanner {
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

public class Shortest_Reach_Dijkstra {
    public static int V,E;

    public static void createGraph(int V, int E, Graph graph){
        Scanner in = new Scanner();

        for (int j=0; j < graph.E; j++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            graph.edge[j].src = a - 1;
            graph.edge[j].dest = b - 1;
            graph.edge[j].weight = w;
        }

        // display the Graph
        for(int i=0; i < graph.E; i++){
            System.out.println(graph.edge[i].src+" "+graph.edge[i].dest+" "+graph.edge[i].weight);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner();

        int query = in.nextInt();

        while(query-- > 0){
            V = in.nextInt();
            E = in.nextInt();

            Graph graph = new Graph(V,E);

            createGraph(V,E,graph);
            int src = in.nextInt();
            graph.BellmanFord(graph, src - 1);
        }
    }

}
