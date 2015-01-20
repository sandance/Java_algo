import java.io.*;
import java.util.*;

public class knapSack_DP {

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



    public static void display(int [][] dp,int n,int W){
        for(int i=0;i<=n;i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
    }





    public static int knapSack_DP(int W, int [] wt, int [] val, int n) {
            int [][] dp = new int [n+1][W+1];

            /* Build the table in bottom up manner */


            for (int col=0;col<=W;col++)
                dp[0][col] =0;
            for(int row=0;row<=n;row++)
                dp[row][0] = 0;


            for(int i=1;i<=n;i++){
                for(int w=1;w <= W; w++){

                    if (wt[i-1] <= w){
                                dp[i][w] = Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                    }
                    else
                        dp[i][w] = dp[i-1][w];
                }
            }
            display(dp,n,W);
            return dp[n][W];
    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int [] val = {10,40,30,50};
        int [] wt = {5,4,6,3};

        //int [] val = {5,40,30,50};
        //int [] wt = {1,6,9};

        int W = 10;


        int max = knapSack_DP(W,wt,val,wt.length);


        System.out.println("KnapSack max value : "+max );


    }

}