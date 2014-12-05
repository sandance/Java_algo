import java.io.*;
import java.util.*;

public class topological_sort {

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

    public static void toposort_util(int v, boolean [] visited, Stack<Integer> stack,List<Integer> [] graph ){

        visited[v] = true;

        // Recursively go through all adjacent vertices to this

        for(int i=0;i < graph[v].size(); i++){
            int p = graph[v].get(i);

            if (!visited[p])
                    toposort_util(i,visited,stack,graph);
        }

        stack.push(v);

    }


    public static void topo_sort(List<Integer>[] graph, int n, int m) {

        Stack<Integer> stack = new Stack<Integer>();

        boolean [] visited = new boolean[n];


        for(int i=0;i< n;i++)
            visited[i] = false;

        // Call the recursive helper function to store topological sort

        for(int i=0;i < n;i++) {
            if(!visited[i]) {
                toposort_util(i,visited,stack,graph);
            }
        }

        while(stack.isEmpty() == false){
            System.out.println(stack.peek());
            stack.pop();
        }


    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // add the edges

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            graph[a].add(b);

        }

        topo_sort(graph,n,m);

    }

}
