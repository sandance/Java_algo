/**
 * Created by NIslam on 8/2/16.
 */

import java.io.*;
import java.util.*;


public class bfs {


    public static void BFS(int s, boolean [] visited , List <Integer> [] graph){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;

        queue.add(s);

        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s);


            // Get all the adjacent vertices
            for(int i=0;i<graph[s].size();i++){
                int p = graph[s].get(i);
                System.out.println("Adjacent vertix: "+p);
                if (!visited[p]){
                    visited[p] = true;
                    queue.add(p);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String [] VE = br.readLine().split(" ");
        int V = Integer.valueOf(VE[0]);
        int E = Integer.valueOf(VE[1]);

        List<Integer> [] graph = new List[V];

        for (int i=0;i<V;i++){
            graph[i] = new ArrayList<Integer>();
        }

        // add the edges
        for(int i=0;i<E;i++){
            String[] l  = br.readLine().split(" ");
            int a = Integer.valueOf(l[0]);
            int b = Integer.valueOf(l[1]);

            graph[a].add(b);
            //graph[b].add(a);


        }

        // Graph is created

        boolean [] visited = new boolean[V];

        for(int i=0;i <V;i++)
            visited[i]=false;

        // call recursive helper function to print DFS traversal

        System.out.println("Enter the vertix of dfs you want");
        int v = Integer.parseInt(br.readLine());


        BFS(v,visited,graph);


    }
}
