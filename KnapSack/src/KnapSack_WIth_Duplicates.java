import java.io.*;
import java.util.*;

public class KnapSack_WIth_Duplicates {

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

    public static int recursive_knapsack_with_duplicates(int [] inputArr, int n,int W){

        /* If Capacity is Zero , nothing to put */
        if (W <=0)
            return 0;

        int max = recursive_knapsack_with_duplicates(inputArr,n,W-1);


        for(int i=0;i<n;i++){
            if ( inputArr[i] <= W){
                int tmp = inputArr[i] + recursive_knapsack_with_duplicates(inputArr,n,W-inputArr[i]);

                if (tmp > max){
                    max = tmp;
                }

            }
        }

        return max;

    }

    public static void display(int [] M, int W){
        for(int i=0;i<W;i++){
            System.out.print(M[i]+ "\t");
        }
    }


    public static int dp_knapsack_with_duplicates(int [] inputArr, int n, int W){
        int [] M = new int [W+1];
        int [] R = new int [W+1];

        for(int i=0;i<W;i++) {
            M[i] = 0;
            R[i] = -1;
        }

        /* For each capacity w in W */
        for (int w=1;w<=W;w++){
            M[w] = M[w-1]; // value from previous row, same column , i mean right above

            for(int i=0;i<n;i++){
                int tmp =0;

                if ( inputArr[i] <= w){
                    tmp = M[w-inputArr[i]] + inputArr[i];
                }

                if(tmp > M[w]){
                    M[w] = tmp;
                    R[w] = i;
                }
            }

        }
        //display(M,W);


        return M[W];



    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int attepts = in.nextInt();


        for(int i=0;i<attepts;i++){
            int size = in.nextInt();
            int weight = in.nextInt();

            int [] inputArr = new int [size];

            for(int j=0;j<inputArr.length;j++){
                inputArr[j] = in.nextInt();
            }

           // int rec_ans = recursive_knapsack_with_duplicates(inputArr,size,weight);
            //System.out.println(rec_ans);

            int dp_ans = dp_knapsack_with_duplicates(inputArr,size,weight);
            System.out.println(dp_ans);

        }




    }

}