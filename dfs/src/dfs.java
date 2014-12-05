import java.io.*;
import java.util.*;


public class dfs {

    public static void DFSUtil(int v, boolean [] visited, List <Integer> [] graph) {

        // Mark the current node as visited and mark it

        visited[v] = true;
        System.out.print(v +" ");

        // Recur for all vertices adjacent to this vertex

        for(int i=0; i < graph[v].size();i++){
            int p = graph[v].get(i);
            System.out.println("The adjacent vertix " + p);
            if(!visited[p]) {
                DFSUtil(p,visited,graph);
            }
        }



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

                graph[a].add(b);
                graph[b].add(a);


            }

            // Graph is created

            boolean [] visited = new boolean[n];

            for(int i=0;i <n;i++)
                    visited[i]=false;

            // call recursive helper function to print DFS traversal

            System.out.println("Enter the vertix of dfs you want");
            int v = Integer.parseInt(br.readLine());


            DFSUtil(v,visited,graph);


    }
}