import java.io.*;
import java.util.*;

public class Maximum_Subarray {

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

    public static int continuous_sum(int [] inputArr, int n){
        //int max_so_far =0, max_ending_here =0;
        int max_so_far =inputArr[0], max_ending_here =inputArr[0];

        // iterate through all elements of the array
        for(int i=1;i< n;i++){
            /*
            max_ending_here = max_ending_here + inputArr[i];

            if ( max_ending_here < 0)
                max_ending_here =0;
            else if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
                */
            // Algo from wikipedia
        //    max_ending_here = Math.max(0,max_ending_here + inputArr[i]);
        //    max_so_far = Math.max(max_so_far,max_ending_here);

            max_ending_here = Math.max(inputArr[i],max_ending_here+inputArr[i]);
            max_so_far = Math.max(max_so_far,max_ending_here);


        }

        return max_so_far;
    }


    public static int noncontinuous_sum(int [] inputArr, int n){
        int [] maxisum = new int [n];
        System.arraycopy(inputArr,0,maxisum,0,inputArr.length);

        for(int i=1;i<n;i++){
            for(int j=0; j<i ;j++){
                if(inputArr[i] >= inputArr[j] && maxisum[i] <= maxisum[j] + inputArr[i]){
                    maxisum[i] = maxisum[j] + inputArr[i];

                }

            }
        }

        Arrays.sort(maxisum);
        return maxisum[n-1];


    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n ;
        int [] inputArr;

        int test_case = in.nextInt();

        for(int i=0;i<test_case;i++){
            n = in.nextInt();
            inputArr = new int [n];
            for(int j=0;j<n;j++) {
                inputArr[j] = in.nextInt();
            }

            int con_sum = continuous_sum(inputArr,n);
            int non_con_sum = noncontinuous_sum(inputArr,n);

            System.out.println(con_sum + " "+non_con_sum);

        }

    }

}