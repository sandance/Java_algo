import java.io.*;
import java.util.*;

<<<<<<< HEAD
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
=======

public class topological_sort {

    public static int n,m;

    /* Algorithm to check the output:



    L ← Empty list that will contain the sorted elements
    S ← Set of all nodes with no incoming edges
    while S is non-empty do
        remove a node n from S
        add n to tail of L
        for each node m with an edge e from n to m do
            remove edge e from the graph
            if m has no other incoming edges then
                insert m into S
    if graph has edges then
        return error (graph has at least one cycle)
    else
        return L (a topologically sorted order)



     */


    public static void toposort_util(int v, boolean [] visited , Stack<Integer> stack,List<Integer> [] graph) {

        // Mark the current node as visited and mark it

        visited[v] = true;

        // Recusively go through all adjacent vertices to this

        for(int i=0; i < graph[v].size(); i++){
            int p = graph[v].get(i);
            if(!visited[p])
                    toposort_util(p,visited,stack,graph);
        }
        // Push current vertex into stack which stores the result
>>>>>>> 847ed0674554a93b65970570b6b80824fc7f0882

        stack.push(v);

    }


<<<<<<< HEAD
    public static void topo_sort(List<Integer>[] graph, int n, int m) {
=======

    public static void topo_sort(List<Integer> [] graph) {
>>>>>>> 847ed0674554a93b65970570b6b80824fc7f0882

        Stack<Integer> stack = new Stack<Integer>();

        boolean [] visited = new boolean[n];

<<<<<<< HEAD

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
=======
        for(int i=0;i<n;i++)
                visited[i] = false;

        // Call the recursive helper function to store topological sort
        // Starting from all vertices one by one

        for(int i=0;i<n;i++) { // going through all vertices
            if (!visited[i]) { // if it is not already visited

                toposort_util(i, visited, stack, graph);


            }
        }


        System.out.println("Before printing topsort :" + stack.size());
        while(!stack.isEmpty()) {

                System.out.println(stack.peek()+" ");
                stack.pop();
>>>>>>> 847ed0674554a93b65970570b6b80824fc7f0882
        }


    }


<<<<<<< HEAD
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
=======

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String [] nm = br.readLine().split(" ");
         n = Integer.valueOf(nm[0]);
         m = Integer.valueOf(nm[1]);


        List<Integer> [] graph = new List[n];


        for(int i=0;i< n ;i++) {
            graph[i] = new ArrayList<Integer>();
        }



        // add the edges

        for(int i=0;i <m;i++){

            String [] l = br.readLine().split(" ");
            int a = Integer.valueOf(l[0]);
            int b = Integer.valueOf(l[1]);

            graph[a].add(b); // as it a directed graph




        } // Graph is created

        topo_sort(graph);


    }


}
>>>>>>> 847ed0674554a93b65970570b6b80824fc7f0882
