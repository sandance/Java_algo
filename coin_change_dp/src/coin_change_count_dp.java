import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 9/19/17.
 */
public class coin_change_count_dp {

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

    public static int count_solutions_dp(int [] coins, int N, int total){

        int [] temp = new int [total+1];

        temp[0] =1;

        for(int i=0; i < coins.length; i++){
            for (int j=coins[i]; j <= total; j++){
                if ( j >= coins[i]){
                    temp [j] += temp [ j - coins[i]];
                    System.out.print("I : "+i+" J: "+j+" coin: "+ coins[i] +"  Array:   ");
                    printArray(temp);
                }
            }
            System.out.println();
        }

        return temp[total];

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

        int counter = count_solutions_dp(coins, N, total);

        System.out.println("Total number of Solutions: "+counter);

    }
}
