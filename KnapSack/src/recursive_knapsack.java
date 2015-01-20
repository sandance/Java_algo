import java.io.*;
import java.util.*;

public class recursive_knapsack {

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

    /**
     *
     * @param W
     * @param wt
     * @param val
     * @param n
     * @return knapSack max value
     */
    public static int knapSack(int W, int [] wt, int [] val, int n){
                    if ( n==0 || W==0)
                       return 0;

                    /* If weight of the nth item is bigger than the knapSack then ignore it */
                    if (wt[n-1] > W){
                    return    knapSack(W,wt,val,n-1);

                    }else {
                        /* Return the maximum of two cases:
                              1) nth item is included
                              2) nth item is not included
                         */

                        return Math.max(val[n-1] + knapSack(W-wt[n-1],wt,val,n-1),knapSack(W,wt,val,n-1));
                    }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int [] val = {60,100,120};
        int [] wt = {10,20,30};
        int W = 50;


        int max = knapSack(W,wt,val,val.length);

        System.out.println("KnapSack max value : "+max);


    }

}