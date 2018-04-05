import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 10/15/17.
 */
public class LIS_recursive {
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
    } // end of Scanner


    public static int lis_recursive(int [] arr, int n){

        // base case
        if (n == 1)
            return 1;

        int max_longest_number = 1;

        // find lis of subproblems

        for (int i=1 ; i <n; i++){

            int temp_lis = lis_recursive(arr,i);

            if ((arr[i-1] < arr [n -1]) && (temp_lis + 1 > max_longest_number)){
                max_longest_number = 1 + temp_lis;


            }

        }

        return max_longest_number;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        //System.out.println("Enter total number of elements\n");
        int n = in.nextInt();


        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        long lis_length = lis_recursive(arr,n);

        System.out.println(lis_length);



    }

}
