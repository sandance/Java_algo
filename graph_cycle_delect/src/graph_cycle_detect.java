import java.io.*;
import java.util.*;
/*
Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree. There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS. In the following graph, there are 3 back edges, marked with a cross sign. We can observe that these 3 back edges indicate 3 cycles present in the graph.



For a disconnected graph, we get the DFS forest as output. To detect cycle, we can check for a cycle in individual trees by checking back edges.

To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. The edge that connects current vertex to the vertex in the recursion stack is a back edge. We have used recStack[] array to keep track of vertices in the recursion stack.
*/

public class graph_cycle_detect {

    public static boolean isCyclicUtil(int v, boolean [] visited, boolean [] recStack, List<Integer> [] graph) {

        // Mark the current node as visited and mark it
        if (visited[v] == false) {
            visited[v] = true;
            recStack[v] = true;

            //System.out.print(v +" ");

            // Recur for all vertices adjacent to this vertex

            for(int i=0; i < graph[v].size();i++){
                int p = graph[v].get(i);
                //System.out.println("The adjacent vertix " + p);
                if(!visited[p] && isCyclicUtil(p,visited,recStack,graph)) {
                    return true;
                //DFSUtil(p,visited,recStack,graph);
                }
                else if(recStack[p])
                    return true;
         }

        recStack[v] = false; // remove the vertex from recursion stack
        return false;



    }


    public static boolean isCyclic(List<Integer> [] graph,int V, int E){


        boolean [] visited = new boolean[V];
        boolean [] recStack = new boolean[V];



        for(int i=0;i <V;i++) {
            visited[i] = false;
            recStack[i] = false;
        }

        // Call the recursive helper function to detect cycle in difference DFS trees

        for(int i=0; i <V;i++) {
            if (isCyclicUtil(i, visited,recStack,graph))
                return true;
        }

        return false;



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // number of vertices
        //int n = Integer.parseInt(br.readLine());
        String [] nm = br.readLine().split(" "); //take vertix and enge numbers
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        List<Integer> [] graph = new List[n];

        for(int i=0; i < n ; i++) {
            graph[i] = new ArrayList<Integer>();

        }

        // add the edges
        for(int i=0; i <m; i++){
            String[] l  = br.readLine().split(" ");
            int a = Integer.valueOf(l[0]);
            int b = Integer.valueOf(l[1]);

            // For directed graph no need to add on both side
            graph[a].add(b);
            //graph[b].add(a);


        }

        // Graph is created



        if(isCyclic(graph,n,m))
            System.out.println("Cycle detected");
        else
            System.out.println("no Cycle found");





    }
}
