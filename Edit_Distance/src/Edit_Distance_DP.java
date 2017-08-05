import java.io.*;
import java.util.*;

public class Edit_Distance_DP {

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

    public static int EditDistanceUtil(String strA, String strB) {
        int m = strA.length();
        int n = strB.length();

        // Create a table to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill up dp[][] in bottom up manner

        // If first string is empty, the only option is to insert
        // all elements of second string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // if second string is empty , remove all elements
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (strA.charAt(i-1) == strB.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;

                    dp[i][j] = Math.min(Math.min(replace, delete), insert);
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String stringA = in.next();
        String stringB = in.next();

        int min_distance = EditDistanceUtil(stringA,stringB);
        System.out.println(min_distance);

    }

}