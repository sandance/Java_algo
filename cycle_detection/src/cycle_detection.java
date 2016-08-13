import java.io.*;
import java.util.*;




public class cycle_detection {

    public static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }


        public long nextLong() {
            return Long.parseLong(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


        public String nextLine() {
            st = null;

            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }


    public static boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, List<Integer>[] graph) {
        visited[v] = true;
        recStack[v] = true;

        // Recur for all vertices adjacent to this vertex

        for (int i = 0; i < graph[v].size(); i++) {
            int p = graph[v].get(i);

            if (!visited[p] && isCyclicUtil(p, visited, recStack, graph)) {
                return true;
            } else if (recStack[p]) {
                return true;

            }
        }
        recStack[v] = false; // remove vertex from recustion stack
        return false;


    }


    /**
     * param : graph is the main Graph
     * param : V , total number of Vertices
     * param : E , total number of Edges
     */


    public static boolean isCyclic(List<Integer> [] graph, int V, int E) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            recStack[i] = false;
        }

        // call recursively the help function

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack, graph))
                return true;
        }
        return false;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter vertices and edges of the graph");
        int n = in.nextInt(); // vertex
        int m = in.nextInt(); // edges

        System.out.println("n"+n);
        List<Integer>[] graph = new List[n];

	for(int i=0;i<n;i++){
		graph[i] = new ArrayList<Integer> ();
	}


        for (int i = 0; i < n; i++) {
            System.out.println("The the edges of the graph");
            int a = in.nextInt();
            int b = in.nextInt();

            graph[a].add(b);
            // graph[b].add(a); For directed graph no need to add on both direction


        }


        if (isCyclic(graph, n, m))
            System.out.println("Cycle detected");
        else
            System.out.println("no cycle found");


    }

}
