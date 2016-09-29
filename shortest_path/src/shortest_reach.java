/**
 * Created by NIslam on 9/14/16.
 */
import java.io.*;
import java.util.*;

class Graph {
    public int V,E;
    public Edge [] edge;

    Graph(int x, int y){
        V = x;
        E = y;

        edge = new Edge[E];
        for(int i=0; i<E;i++)
            edge[i] = new Edge();
    }


    public void printArr(int [] dist, int src, boolean [] visited){
        //System.out.println();
        for(int i=0; i < dist.length; i++) {
            if (i == src)
                continue;
            System.out.print(dist[i]+" ");
        }
    }

    public void BellmanFord(Graph graph, int src, boolean[] visited) {
        int V = graph.V;
        int E = graph.E;

        int [] dist = new int [V];

        for(int i=0; i <V;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        visited[src] =true;

        for(int i=1;i<V;i++){
            for(int j=0;j<E;j++){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;


                if ( dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    visited[v]=true;
                }
            }
        }



        for(int i=0; i< visited.length;i++){
            if (visited[i] == false){
                dist[i] = -1;
            }
        }
        printArr(dist,src,visited);

    }
}



class Edge  implements Comparable<Edge> {
    public int src, dest, weight;

    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
}




public class shortest_reach {



    public static int V, E;
/*
    public static void printArr(boolean [] visited, int v){

        for (int i=1; i <= V; i++  ){
            if (visited[i]==false) {
                System.out.print("-1" + " ");
                continue;
            }
            else if (i==v)
                continue;
            System.out.print(6+" ");
        }
        System.out.println();
    }
*/

    public static void createGraph(int V, int E, Graph graph){
        Scanner in = new Scanner(System.in);

        for(int j=0; j < graph.E; j++){
            int a = in.nextInt();
            int b = in.nextInt();
            //int w = in.nextInt();

            graph.edge[j].src = a-1;
            graph.edge[j].dest = b-1;
            graph.edge[j].weight = 6;
        }

        // display the Graph
        /*
        for(int i=0; i < graph.E; i++){
            System.out.println("Edges "+graph.edge[i].src+" "+graph.edge[i].dest+"weight: "+graph.edge[i].weight);
        }
        */

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        int query = in.nextInt();


        while(query-- > 0) {

            V = in.nextInt();
            E = in.nextInt();

            Graph graph = new Graph(V,E);
            boolean [] visited = new boolean [V];
            Arrays.fill(visited, false);

            createGraph(V,E,graph);
            int src = in.nextInt();
            graph.BellmanFord(graph,src-1,visited );

        }
    }
}