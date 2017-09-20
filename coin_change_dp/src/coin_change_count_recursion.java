import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Created by NIslam on 9/19/17.
 */
public class coin_change_count_recursion {

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

    public static int count_solutions(int [] coins, int N,int total){


        // base case: If total =0 then there is 1 solution ( do not include any coin)
        if (total==0){
            return 1;
        }

        // If total number of coins are less than 0 then no solution
        if ( total < 0){
            return 0;
        }

        // if there are no coins and N is greater than 0, then no solution
        if ( N <= 0 && total >= 1){
            return 0;
        }

        // count the sum of solutions by i) including coins[N-1] ii) excluding coins[N-1]
        return count_solutions(coins, N-1, total) + count_solutions(coins, N, total - coins[N-1]);


    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter total number of coins: ");
        int N = in.nextInt();


        int[] coins = new int[N];

        System.out.println("Enter coin denomination: ");

        Arrays.fill(coins, 0);

        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
        }

        System.out.println("Enter amount for which we are making change: ");
        int total = in.nextInt();

        int counter = count_solutions(coins, N, total);

        System.out.println("Total number of Solutions: "+counter);

    }
}

