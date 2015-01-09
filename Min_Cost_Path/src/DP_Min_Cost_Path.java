import java.io.*;
import java.util.*;

public class DP_Min_Cost_Path {

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

    public static int minCost(int [][] cost, int x,int y){
        int [][] opt = new int [x+1][y+1];

        opt[0][0] = cost[0][0];

        /* Intialize first row of the array */
        for(int i=1;i<=y;i++){
            opt[0][i] = opt[0][i-1] + cost[0][i];
        }

        /* Initialize first column of the array */

        for(int j=1;j<=x;j++){
            opt[j][0] = opt[j-1][0] + cost[j][0];
        }


        /* Now the diagonals and rest of the array */

        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                opt[i][j] = Math.min(Math.min(opt[i][j-1], opt[i-1][j-1]), opt[i-1][j]) + cost[i][j];
            }
        }

        return opt[x][y];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);



        int [][] input = {
                {1,2,3}, {4,8,2}, {1,5,3} };

        int n=3,m=3;

        int min_cost = minCost(input,2,2);
        System.out.println(min_cost);


    }

}