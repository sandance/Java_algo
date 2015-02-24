import java.io.*;
import java.util.*;

public class LCS_Correct_Way {

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
     * @param x
     * @param y
     * @param m
     * @param n
     * @param opt
     */

    public static void display_lcs(String x, String y, int m, int n, int [][] opt){
        int i=0,j=0;

        while(i< m && j <n){
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }else if (opt[i+1][j] >= opt[i][j+1]){
                i++;
            }else
                j++;

        }
        System.out.println();
    }




    /**
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return maximum size of the subsequence
     */
    public static int LCS(String str1, String str2, int m, int n){
        int [][] L =new int [m+1][n+1];

        int i,j;

        for(i=m-1;i>=0 ;i--){
            for(j=n-1;j>=0;j--){
                if (str1.charAt(i) == str2.charAt(j))
                    L[i][j]= L[i+1][j+1] + 1;
                else
                    L[i][j] = Math.max(L[i+1][j],L[i][j+1]);
            }
        }

        /**
        for(int k=m-1;k>=0;k--) {
            for (int l = n - 1; l >= 0; l--) {
                System.out.print(L[k][l] + " ");
            }
            System.out.println();
        }
         */
        display_lcs(str1,str2,m,n,L);
        return L[0][0];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String a = in.next();
        String b = in.next();

        int max_len = LCS(a,b,a.length(),b.length());

        System.out.println(max_len);

    }

}