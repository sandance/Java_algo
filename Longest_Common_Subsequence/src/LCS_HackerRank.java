import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by nazmul on 1/21/15.
 */
public class LCS_HackerRank {

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

    public static void display(int [][] dp, int m,int n){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){

                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void display_lcs(int [] x, int [] y, int n, int m, int [][] opt,int index){
        int i=n,j=m;
        int [] display = new int [index+1];
        int size=index;


        while(i > 0  && j > 0){
           // System.out.println(x[i-1]+"\t"+y[j-1]);
            if (x[i-1] == y[j-1]) {
                display[index-1] = x[i-1];

                //System.out.println(x[i-1]);
                i--;
                j--;
                index--;
            }
            else if (opt[i-1][j] >= opt[i][j-1]){
                i--;
            }else
                j--;

        }

        for(i=0;i<size;i++) {
            System.out.print(display[i] + " ");
        }
        //System.out.println();
    }



    public static int lcs(int [] input1 , int [] input2, int n, int m){
        // Memorization
        int [][] L = new int [n+1][m+1];
        int i,j;


        for(i=0;i<=n;i++){
            for(j=0;j<=m;j++){
                //System.out.println(str1.charAt(i) +'\n' + str2.charAt(j));
                if (i==0 || j==0)
                    L[i][j] =0;
                else if (input1[i-1]== input2[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
            }
        }
        // L[m][n] contains length of LCS for X[0..n-1] and Y [0..m-1]
       // display(L,n,m); // To display actual DP
        display_lcs(input1,input2,n,m,L,L[n][m]);
        return L[n][m];

    }



/*
    public static void new_display_lcs(int [] x, int [] y, int n, int m, int [][] opt){

    }

*/

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int [] inputArr1 = new int [n];
        int [] inputArr2 = new int [m];


        for(int i=0;i<n;i++)
            inputArr1[i] = in.nextInt();
        for(int i=0;i<m;i++)
            inputArr2[i] = in.nextInt();


        int max_len = lcs(inputArr1,inputArr2,n,m);

        //System.out.println("Maximum length of lcs:\t" + max_len);

    }

}