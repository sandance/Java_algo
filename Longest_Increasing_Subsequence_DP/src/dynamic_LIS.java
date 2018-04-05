import java.io.*;
import java.util.*;
import java.math.BigInteger;


/**
 * Longest Increasing Sequence
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}
 *
 */
public class dynamic_LIS {

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


    /**
     *
     * @param arr
     * @param n
     * @return maximum length of LIS
     */
    public static long lis_dp(int [] arr, int n){
        int [] dp = new int [n];

        /* Initialize LIS values for all indices */
        for(int i=0; i<n;i++)
            dp[i] = 1;

        /* Compute Optimized version of LIS in bottom up manner */

        List<Integer> [] idx = new List[n];

        for(int i=0; i< idx.length;i++){
            idx[i] = new ArrayList<Integer>();
        }


        for(int i=1;i<n;i++){

            // store the numbers for LIS with printing number // additional problem

            //idx[i-1] = new ArrayList<Integer>();

            for(int j=0;j<i;j++){


                if(arr[i] > arr[j] && dp[i] < dp[j] + 1 ) {
                    dp[i] = dp[i] + 1;
                    idx[i].add(arr[j]);
                }
            }
        }

        /* PICK Maximum of all LIS values */

        Arrays.sort(dp);
        printArr(dp);

        /* wrong implementation

        for (int i=0; i < idx.length; i++){
            System.out.println("Index i: "+i);
            for(int j=0; j < idx[i].size(); j++){
                System.out.print(idx[i].get(j)+" ");
            }
            System.out.println();
        }
        */
       return dp[n-1];


    }

    public static void printArr(int []  dp){
        for (int i =0; i < dp.length; i++){
            System.out.print("  i :" + i + "  arr[i]:  "+ dp[i]+"  ");
        }
        System.out.println();
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

        long lis_length = lis_dp(arr,n);

        System.out.println(lis_length);




    }

}