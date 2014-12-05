import java.io.*;
import java.util.*;

public class cycle_detection_undirected_graph {

    // Global variables

    public static int n,m;


    /*
    This is the Kosaraju's algorithm to find all the cycles in a graph

    1) Create a empty stack S and do DFS traversal of a graph. In DFS, after calling recursive DFS
       for adjacent vertices , push the vertex into stack

    2) Reverse direction of all arcs to obtain transpose graph

    3) By one by one , pop a vertex from S and while S is not empty , let that is v, from v print
       its strongly connected components
    */

    public static boolean isCyclicUtil(int v, boolean [] visited, int parent, List<Integer> [] graph) {

        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex

        /*
        Algo:

        For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and
        u is not parent of v, then there is a cycle in graph.
        If we don’t find such an adjacent for any vertex, we say that there is no cycle.

         */

        for(int i=0; i< graph[v].size(); i++) {
            int p = graph[v].get(i);

            if(!visited[i]) {
                if (isCyclicUtil(p, visited, v,graph))
                    return true;
            }

            // If an adjacent is visited and not parent of current vertex

            else if ( p != parent)
                return true;


        }

        return false;

    }

    public static boolean isCyclic(List<Integer> [] graph){

        boolean [] visited = new boolean[n];

        for(int i=0;i <n;i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in different DFS trees

        for(int u=0 ; u < n ; u++){
            if(!visited[u] && isCyclicUtil(u, visited, -1,graph))
                return true;
        }
        return false;

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // take vertices and edges

         n = in.nextInt();
         m = in.nextInt();

        List<Integer> [] graph = new List[n];

        for ( int i=0; i<n;i++){
            graph[i] = new ArrayList<Integer>();

        }

        for(int i=0;i <m;i++){
            //String  [] ll = in.next().split(" ");
            int  a = Integer.valueOf(in.next());
            int  b = Integer.valueOf(in.next());

            graph[a].add(b);
            graph[b].add(a);

            
        }

        // Graph is created

        if(isCyclic(graph)){
            System.out.println("Graph contains cycle");

        }
        else
              System.out.println("Graph contains no cycle");
    }
}