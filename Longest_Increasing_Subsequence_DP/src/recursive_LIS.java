import java.io.*;
import java.util.*;


/**
 * Longest Increasing Sequence
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}
 *
 */
public class recursive_LIS {

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

    int lis_memo(int [] arr, int n, int max){
        /* Base Case */

        if(n==1)
            return 1;

        int res,max_ending_here = 1;

        /* Recursively get length of  all LIS ending with arr[n - 1]
         */

        for(int i=0;i)

    }

    /**
     *
     * @param arr
     * @param n
     * @return maximum length of lis
     */
    int lis(int [] arr, int n){
         int max = 1;

        max = lis_memo(arr,n,max);

        return max;
    }




    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter total number of elements\n");
        int n = in.nextInt();


        int [] arr = new int [n];

        int lis_length = lis(arr,n);

        System.out.println("Length of Lis is : " + lis_length);



    }

}