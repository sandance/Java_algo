import java.io.*;
import java.util.*;



/**
 * Created by nazmul on 8/7/14.
 */
public class Kruskal_MST {

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


    public static void main(String[] args) throws IOException {

            DirectedGraph dg = new DirectedGraph();
            KruskalUtil ks = new KruskalUtil();


            Map<Integer,Map<Integer,Double>> graph = new HashMap<Integer, Map<Integer, Double>>();
            Scanner sc = new Scanner();

            /* Enter the

             */

            int n = sc.nextInt();
            int m = sc.nextInt();

            for(int i=0 ; i<n ;i++)
                dg.addNode(i);

            for(int i=0;i<m;i++){

                int a = sc.nextInt();
                int b = sc.nextInt();
                int w = sc.nextInt();

                dg.addEdge(a,b,w);

            }

            graph =








    }

}