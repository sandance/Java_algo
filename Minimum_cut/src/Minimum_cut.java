/**
 * Created by NIslam on 8/30/16.
 */
// Java program for implementation of Ford Fulkerson algorithm
import java.util.*;
import java.lang.*;
import java.io.*;


class Minimum_cut
{
    static final int V = 6; //Number of vertices in graph
    /* Returns true if there is a path from source 's' to sink
      't' in residual graph. Also fills parent[] to store the
      path */

    public static void printSet(ArrayList<Integer> list){
        for(int i=0; i< list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static  ArrayList<Integer>  bfs (int [][] resGraph, int s){
        boolean [] visited = new boolean[V];
        Arrays.fill(visited, false);

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> setA = new ArrayList<>();

        queue.add(s);
        visited[s] = true;
        //setA.add(s);

        while(!queue.isEmpty()) {
            s = queue.poll();
            setA.add(s);
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && resGraph[s][v] > 0) {
                    queue.add(v);

                    visited[v] = true;
                }
            }

        }
        return setA;

    }

    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        // Create a visited array and mark all vertices as not
        // visited
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]= -1;

        // Standard BFS Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph
    int [][] fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int parent[] = new int[V];

        int max_flow = 0;  // There is no flow initially

        // Augment the flow while tere is path from source
        // to sink
        while (bfs(rGraph, s, t, parent))
        {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            // Add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return rGraph;
    }



    // Driver program to test above functions
    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a graph shown in the above example
        /*
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        */

        String filename=args[0];
        FileReader fr=null;
        int [][] graph;

        try {
            fr = new FileReader(filename);
            Scanner in = new Scanner(fr);

            // get number of Vertices
            String line = in.nextLine();
            int numVertices = Integer.parseInt(line);

            graph = new int [numVertices][numVertices];

            for(int i=0;i<numVertices;i++){
                for(int j=0;j<numVertices;j++){
                    graph[i][j] = 0;
                }
            }

            while(in.hasNextLine()){
                line = in.nextLine();
                String [] tokens = line.split(" ");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                int c = Integer.parseInt(tokens[2]);
                graph[u][v] = c;

            }

        }finally {
            if ( fr !=null) fr.close();
        }

        Minimum_cut m = new Minimum_cut();

        // find the residual graph

        int [][] resGraph = m.fordFulkerson(graph, 0, 5);

        // find vertices reachable from source vertex in residual Graph,
        // use BFS from source vertex

        ArrayList<Integer> setA = bfs(resGraph,0);
        printSet(setA);
        // find V - setA
        ArrayList<Integer> setB = new ArrayList<Integer> ();
        for (int i=0; i < V; i++){
            if (!setA.contains(i)){
                // V - setA array
                setB.add(i);

            }

        }
        System.out.println("non reachable vertex from source are: ");
        printSet(setB);
        System.out.println();
        int min_cut =0 ;
        // now find edges from setA to setB
        for (int i=0;i <setA.size();i++){
            for( int j=0; j < setB.size(); j++){
                if (graph[setA.get(i)][setB.get(j)] !=0)
                    System.out.println("cut value: "+graph[setA.get(i)][setB.get(j)]);
                    min_cut += graph[setA.get(i)][setB.get(j)];
            }
        }

        System.out.println("min-cut: "+min_cut);

    }
}