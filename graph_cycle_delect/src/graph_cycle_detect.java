import java.io.*;
import java.util.*;


public class graph_cycle_detect {

    public static boolean isCyclicUtil(int v, boolean [] visited, boolean [] recStack, List<Integer> [] graph) {

        // Mark the current node as visited and mark it

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