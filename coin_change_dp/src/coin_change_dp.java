import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 8/5/17.
 */
public class coin_change_dp {


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

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void coinChanged(int [] coins, int [] C, int [] S, int total){

/*
        C[0] = 0;
        S[0] = 0;
        int coin=0;




        for(int p=1; p <= total; p++){
            int minCoin = Integer.MAX_VALUE;

            for(int i=1;i < coins.length;i++){
                if (coins[i] <= p){
                    System.out.println("P: "+p+" I: "+i);
                    if ( (1+ C[p - coins[i]]) < minCoin){
                        minCoin = 1 + C[p - coins[i]];
                        coin = i;
                    }
                }
            }
            C[p] = minCoin;
            S[p] = coin;
        }



         * Time complexity - O(coins.size * total)
         * Space complexity - O(coins.size * total)
*/

        C[0] = 0;
        S[0] = 0;

        for(int i=1; i <= total; i++){
            C[i] = Integer.MAX_VALUE - 1;
            S[i] = -1;
        }


        for (int j=0; j < coins.length; j++){
            for (int i=1; i <= total; i++){
                if ( i >= coins[j]){
                    if ( C[i - coins[j]] +1 < C[i] ){
                        C[i] = 1 + C[i - coins[j]];
                        S[i] = j;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter total number of coins: ");
        int N = in.nextInt();


        int [] coins = new int[N];

        System.out.println("Enter coin denomination: ");

        Arrays.fill(coins,0);

        for (int i=0;i < N;i++) {
            coins[i] = in.nextInt();
        }

        System.out.println("Enter amount for which we are making change: ");
        int A = in.nextInt();


        // Minimum number of coins required to make change
        int [] C = new int [A+1];

        // S contain the index of the coin to be included
        int [] S = new int [A+1];

        // compute minimum number of coins required

        coinChanged(coins, C,S,A);

        // count(S,m,n)= count( S, m - 1, n ) + count( S, m, n-S[m-1] );

        
        // Display content of C
        printArray(C);

        // display content of S
        printArray(S);

        // display the minimum number of coins required to make change for A
        System.out.println("Minimum number of coins required: " + C[A] + " for change of:" + A);

        System.out.println("Diplay coins used in optimal solution: ");

        int a = A;

        while (a > 0){
            System.out.print(coins[S[a]]+" ");
            a = a - coins[S[a]];
        }


    }
}
