import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Created by nazmul on 8/6/14.
 */



public class Detect_Cycle_Union_Find<T> {
    Undirected_Graph<T> graph = new Undirected_Graph<T>();


    UnionFind<T> unionFind = new UnionFind<T>();


    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    // End of Input Class

    for(T node : graph)
    {
        unionFind.add(node);
    }

    List<Edge<T>> edges = getEdges(graph);
    int numEdges = 0;

    for (Edge<T> edge: edges) {
            /* If the endpoints are connected, skip this edge. */
            if (unionFind.find(edge.start) == unionFind.find(edge.end))
                continue;

            /* Link the endpoints together. */
            unionFind.union(edge.start, edge.end);



            /* Setup partition of nodes in a union Find Structure */

    /**
     * if(isCycle(graph))
     * System.out.println("Graph contains cycle");
     * else {
     * System.out.println("No cycle");
     * }
     */


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        System.out.println("Enter number of Vertices and Edges\n");

        int V = sc.nextInt();
        int E = sc.nextInt();

        for (int i = 0; i < V; i++)
            graph.addNode(i);

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int weight = sc.nextInt();
            graph.addEdge(a, b, weight);


        } // vertex and edge is included


    }
}