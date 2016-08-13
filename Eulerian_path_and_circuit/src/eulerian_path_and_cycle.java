import java.io.*;
import java.util.*;



/**
 * Created by NIslam on 8/7/16.
 */
public class eulerian_path_and_cycle {

    public static void DFSUtil(int v, boolean [] visited, List<Integer> [] graph){
        visited[v] = true;

        // Recur for all vertices adjancent to this vertex
        Iterator<Integer> i= graph[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visited[n]){
                DFSUtil(n, visited,graph);
            }
        }
    }

    public static boolean isConnected(boolean [] visited, List<Integer> [] graph){
        // Find a vertex with non-zero degree
        int V= visited.length;
        int i=0;
        for (i=0; i< V ; i++){
            if (graph[i].size() !=0)
                break;
        }

        if (i==V){
            return true;

        }
        // Start DFS traversal from a vertex  with non-zero -degree
        DFSUtil(i,visited, graph);

        // check if all non-sero degree vertices are visited
        for(i=0;i< V;i++){
            if (visited[i] == false & graph[i].size() > 0){
                return false;
            }
        }
        return true;
    }


    public static int isEulerian(int v, int n, boolean [] visited , List <Integer> [] graph ) {
        /*
        The function retuns one of the following
        0 --> If graph is not Eulerian
        1 --> If graph has a euler path (Semi Eulerian)
        2 --> If graph has a euler circuit
         */
        // check if all non-zero vertices are connected
        if (isConnected(visited, graph) == false)
            return 0;

        // Count vertices with odd degree
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() % 2 != 0)
                odd++;
        }

        // If count is more than 2 ,
        // then graph is not Eulerian
        if (odd > 2)
            return 0;
        else if (odd==2)
            return 1;
        else
            return 2;


    }
        // if odd count is 2, then semi-eulerian
        // if odd count is 0, then eulerian
        // Note that odd count can never be 1 for undired graph
        //if (odd==2)
        //return 1;
        //else return 2;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // number of vertices
        //int n = Integer.parseInt(br.readLine());
        String[] nm = br.readLine().split(" "); //take vertix and enge numbers
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        List<Integer>[] graph = new List[n];
        List<Integer>[] rev_graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
            rev_graph[i] = new ArrayList<Integer>();

        }

        // add the edges
        for (int i = 0; i < m; i++) {
            String[] l = br.readLine().split(" ");
            int a = Integer.valueOf(l[0]);
            int b = Integer.valueOf(l[1]);

            graph[a].add(b);
            rev_graph[b].add(a);


        }

        // Graph is created

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            visited[i] = false;

        // call recursive helper function to print DFS traversal

        //System.out.println("Enter the vertix of dfs you want");
        //int v = Integer.parseInt(br.readLine());

        int v = 0 + (int) (Math.random() * (n-1));

        //DFSUtil(v,visited,graph);
        int result = isEulerian(v,n,visited, graph);
        if (result==1)
            System.out.println("Graph has is not eulerian\n");
        else if (result==0)
            System.out.println("Graph has Euler path");
        else
            System.out.println("Graph has Euler Cycle");


    }



}
