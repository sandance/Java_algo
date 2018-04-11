import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 4/11/18.
 */
public class Cutting_Rod_DP {

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

    public static int cut_rod_dp(int [] price, int n){

        int max_value = Integer.MIN_VALUE;

        /*
        Use Dp to cut the Rod in different pieces

         */
        int [] val = new int [n];
        val[0] =0; // for n =0

        for (int i=1; i < n;i++) {
            for (int j = 0; j < i; j++) {
                max_value = Math.max(max_value, price[j] + val[i - j - 1] );
            }

            val[i] = max_value;
        }

        return max_value;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        //System.out.println("Enter total number of elements\n");
        int n = in.nextInt();



        int [] price = new int [n];

        for(int i=0;i<n;i++){

            price[i] = in.nextInt();
        }

        //int val = cut_rod_recv(price,n);

        int val = cut_rod_dp(price, n);

        System.out.println("Maximum value : "+val);



    }
}
