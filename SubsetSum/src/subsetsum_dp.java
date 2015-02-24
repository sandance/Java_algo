import java.io.*;
import java.util.*;
import java.lang.*;


public class subsetsum_dp {

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


    public static  boolean SubsetSum(int [] w, int W){

        int n = w.length;
        boolean [][] subSet = new boolean [W+1] [n+1];

        //Arrays.asList(subSet,0);


        /* If the sum is zero, the answer is zero */
        for(int j=0;j<=n;j++){
          subSet[0][j] = true;
        }

        for(int i=1;i<=W;i++)
            subSet[i][0] = false;


        for (int i=1;i<=W;i++){ // For every row
            for(int j=1;j<=n;j++) { // for every column
                subSet[i][j] = subSet[i][j-1];
                if (i >= w[j-1]){
                     // case where item cant fit take from previous
                    subSet[i][j] = subSet[i][j] || subSet[i-w[j-1]][j-1];

                }
//                System.out.println(i+"\t"+j);
//                subSet[i][j] = Math.max(subSet[i-1][j],w[i]+subSet[i-1][W-w[i]]);
            }
        }
/*
        for(int i=0;i<=W;i++){
            for(int j=0;j<=n;j++){
                System.out.println(subSet[i][j]+" ");
            }
            System.out.println();
        }
*/
        return subSet[W][n];
    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        int n = in.nextInt();

        int[] aSet = new int[n];

        for (int i = 0; i < n; i++)
            aSet[i] = in.nextInt();


        int W = in.nextInt();


        if (SubsetSum(aSet, W))
            System.out.println("Subset exist");
        else
            System.out.println("Subset does not exist");


    }
}