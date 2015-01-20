import java.io.*;
import java.util.*;

public class Maximum_Sum_Increasing_Subsequence {

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

    public static int maximum_sum_dp(int [] array, int n){
        int [] maxArr = new int [n];

        System.arraycopy(array,0,maxArr,0,n);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if (array[i] > array[j] && maxArr[j] < maxArr[i] + array[i] )
                    maxArr[i] = maxArr[j] + array[i];
            }
        }

        Arrays.sort(maxArr); // last element of sorted array is maximum
        return maxArr[n-1];

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        int [] input = new int [n];

        for(int i=0;i<n;i++){
            input[i] = in.nextInt();
        }

        int sum = maximum_sum_dp(input,n);

        System.out.println(sum);
    }

}