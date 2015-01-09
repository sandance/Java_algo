import java.io.*;
import java.util.*;

public class Coin_Exchange_DP {

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
     * @param input
     * @param n = total
     * @param k num of elements in
     * @return
     */

    public static int coin_exchange(int [] input,int n,int k){
        int [][] dp = new int [k+1][n+1];

        /* when j=0 then c[i][j] = 0 and here suppose k = 4*/
        for(int i=0;i<=k;i++){
            dp[i][0] = 0;
        }

        /* when i=0 then c[0][j] = j */
        for(int i=1;i<=n;i++){
            dp[0][i] = i;
        }

        /* for rest */

        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                if(j < input[i-1]){
                    /*  if the element index i*/
                    dp[i][j] = dp[i-1][j]; // not counting
                } else
                    dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-input[i-1]]);
                System.out.println(i +" and "+j + " value\t" + dp[i][j] );

            }
        }


    return dp[k][n];

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter number of elements : ");
        int k = in.nextInt();

        int [] arr = new int [k];

        for(int i=0;i<k;i++){
            arr[i] = in.nextInt();
        }

        int total_n = in.nextInt();

        int m = coin_exchange(arr,total_n,k);

        System.out.println("Mimum number of coins needed: "+ m);
    }





}