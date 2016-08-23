/**
 * Created by NIslam on 8/17/16.
 */

import java.util.*;

public class Graph {
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


