import java.io.*;
import java.util.*;

/**
 * Created by NIslam on 8/17/16.
 */
public class BellmanFord {
    public static int n, m;

    public static void createGraph(int V, int E, Graph graph) {
        Scanner in = new Scanner();

        for (int j = 0; j < graph.E; j++) {
            System.out.println("Enter edge: " + j);
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            graph.edge[j].src = a;
            graph.edge[j].dest = b;
            graph.edge[j].weight = w;


        } // graph is created

        // display the Graph

        for (int i = 0; i < graph.E; i++) {
            System.out.println("Edges " + graph.edge[i].src + " " + graph.edge[i].dest+"  Weight: "+graph.edge[i].weight);

        }


    }


    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        Graph graph = new Graph(n, m);

        // step 1: Sort all the edges in non-decreasing order
        // of weight .


        createGraph(n, m, graph);

        // create MST
        System.out.println("Enter the source of the Graph you want shortest path for : ");
        int src = in.nextInt();
        graph.BellmanFord(graph,src);




    }
}
