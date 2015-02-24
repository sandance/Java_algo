import java.io.*;
import java.util.*;

public class backtracking_subsetSum {

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


    /**
     * Prints the SubSet Array
     * @param target int []
     * @param t_size int
     */
    public static void printSubSet(int [] target, int t_size) {
        for (int i = 0; i < t_size; i++) {
            System.out.println(target[i] + " ");
        }
        System.out.println();
    }
    /**
     * Baktracking function which is called recursively to find the subset sum
     * @param weights int []
     * @param target int []
     * @param size int
     * @param t_size int
     * @param ssum int ; it starts with 0
     * @param ite int
     * @param target_sum int
      */

    public static void subsetsum_back(int [] weights, int [] target,int size,int t_size,int ssum,int ite, int target_sum){

        if ( target_sum == ssum){
            // We found a subset
            printSubSet(target,t_size);

            // Exclude previously added item and consider next candidate
            subsetsum_back(weights, target, size, t_size -1 , ssum - weights[ite], ite +1, target_sum);
            return;
        }
        else{
            // Generate nodes along the breadth
            for(int i =ite; i < size; i++){
                target[t_size] = weights[i];
                // consider next level node (along depth)
                subsetsum_back(weights , target, size, t_size +1 , ssum + weights[i] , ite +1 , target_sum);
            }
        }


    }

    /**
     *
     * @param weights int []
     * @param n int
     * @param target_sum int
     */
    public static void generateSubSets(int [] weights, int n, int target_sum){
        int [] tuplet_vector = new int [n];
        subsetsum_back(weights,tuplet_vector,n,0,0,0,target_sum);

    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter the size of the array\n");
        int n = in.nextInt();

        int [] weights = new int [n];

        for(int i=0;i<n;i++){
            weights[i] = in.nextInt();
        }

        System.out.println("Enter subset sum value\n");
        int target_sum = in.nextInt();

        generateSubSets(weights,n,target_sum);



    }

}