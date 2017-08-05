import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 8/5/17.
 */
public class min_cost_path_dp {

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

    public static void printArray(int [][] cost, int m, int n){
        for(int i=0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter number of rows");
        int row = in.nextInt();
        System.out.println("Enter number of Columns");
        int column = in.nextInt();

        int [][] cost = new int [row][column];

        for (int i=0; i< row; i++){
            for (int j=0;j < column;j++){
                cost[i][j] = in.nextInt();
            }
        }

        printArray(cost,row, column);

        int [][] dp = new int [row][column];


        // build the dp tree in top down fashion

        // initialize dp
        dp[0][0] = cost[0][0];

        for(int i = 1; i < row; i++)
            dp[0][i] = dp[0][i-1] + cost[0][i];

        for(int j=1; j < column; j++)
            dp[j][0] = dp[j-1][0] + cost[j][0];

        for (int i=1; i < row ;i++){
            for (int j=1; j < column; j++){
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j])) + cost[i][j];
            }
        }

        // print output
        System.out.println("Final Array is: ");
        printArray(dp, row, column);
        System.out.println("The min cost is: " +dp[row-1][column-1]);

    }
}
