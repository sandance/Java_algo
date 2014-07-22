import java.io.*;
import java.util.*;


public class strongly_connected_components {

    public static int DFSUtil(int v, boolean [] visited, List <Integer> [] graph, HashSet<Integer> list) {

        // Mark the current node as visited and mark it




        visited[v] = true;
        list.add(v);
        System.out.print(v +" ");

        // Recur for all vertices adjacent to this vertex

        for(int i=0; i < graph[v].size();i++){
            int p = graph[v].get(i);
            System.out.println("The adjacent vertix " + p);
            if(!visited[p]) {
                DFSUtil(p,visited,graph,list);

            }
        }

        return list.size();

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
        List<Integer> [] rev_graph = new List[n];

        for(int i=0; i < n ; i++) {
            graph[i] = new ArrayList<Integer>();
            rev_graph[i] = new ArrayList<Integer>();

        }

        // add the edges
        for(int i=0; i <m; i++){
            String[] l  = br.readLine().split(" ");
            int a = Integer.valueOf(l[0]);
            int b = Integer.valueOf(l[1]);

            graph[a].add(b);
            rev_graph[b].add(a);


        }

        // Graph is created

        boolean [] visited = new boolean[n];

        for(int i=0;i <n;i++)
            visited[i]=false;

        // call recursive helper function to print DFS traversal

        //System.out.println("Enter the vertix of dfs you want");
        int v = 0 + (int) (Math.random() * (n-1));


        HashSet<Integer> list = new HashSet<Integer>();

        HashSet<Integer> rlist = new HashSet<Integer>();

        int f_count = DFSUtil(v,visited,graph,list);
        System.out.println("Front count"+f_count);

        // do it again
        for(int i=0;i <n;i++)
            visited[i]=false;



        int b_count = DFSUtil(v,visited,rev_graph,rlist);
        System.out.println("end count"+b_count);


        if (f_count == n && f_count == b_count){
            System.out.println("The Graph is strongly connected");

        } else
            System.out.println("Graph is not strongly connected");



    }
}