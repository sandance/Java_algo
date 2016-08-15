import java.io.*;
import java.util.*;



public class Union_find {

    public static int n,m;

    public static void createGraph(int V, int E, Graph graph) {
         Scanner in = new Scanner();

        for (int j=0;j<graph.E;j++){
            System.out.println("Enter edges for vextex: " + j);
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
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        Graph graph = new Graph(n,m);

        createGraph (n,m,graph);
        // check cycle

        if (graph.isCycle(graph) == 1){
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph does not contain cycle");
        }

    }

}