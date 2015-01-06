import java.io.*;
import java.util.*;

public class Longest_Common_Subsequence {

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


    public static int lcs(String str1 , String str2 , int m, int n){
        // Memorization
        int [][] L = new int [m+1][n+1];
        int i,j;


        for(i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                //System.out.println(str1.charAt(i) +'\n' + str2.charAt(j));
                if (i==0 || j==0)
                    L[i][j] =0;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
            }
        }
        // L[m][n] contains length of LCS for X[0..n-1] and Y [0..m-1]

        return L[m][n];

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        String inputArr1 = in.next();
        String inputArr2 = in.next();

        int max_len = lcs(inputArr1,inputArr2,inputArr1.length(),inputArr2.length());

        System.out.println("Maximum length of lcs:\t" + max_len);

    }

}