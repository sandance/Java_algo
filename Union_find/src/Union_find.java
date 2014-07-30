import java.io.*;
import java.util.*;






public class Union_find {

    public static int n,m;

    public static void createGraph(int V, int E, Scanner in) {

        Graph graph = new Graph();
        graph.V = V;
        graph.E = E;

        Graph [] edge = new Graph[E];


            for (int j=0;j<graph.E;j++){
                int a = in.nextInt();
                int b = in.nextInt();



                graph.edge[a].src=a;
                graph.edge[a].dest=b;


        } // graph is created

        // display the Graph

        for(int i=0;i<graph.E;i++){
            System.out.println("Edges " + graph.edge[i].src + " " + graph.edge[i].dest );

        }


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();

        createGraph (n,m,in);



    }

}