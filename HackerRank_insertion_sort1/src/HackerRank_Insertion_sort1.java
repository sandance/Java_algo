import java.io.*;
import java.util.*;




/**
 * Created by nazmul on 12/9/14.
 */


public class HackerRank_Insertion_sort1 {

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

    public static void printArray(int []  ar){
        for(int i=0;i<ar.length;i++)
            System.out.print(ar[i] + " ");
        System.out.println();
    }

    public static void insertIntoSorted(int[] inputArr) {

            for ( int i = 1,j; i < inputArr.length; i++) {
                //System.out.print(inputArr[0]);
                int temp = inputArr[i];
                for (j = i; j > 0 && temp < inputArr[j - 1]; j--) {
                    inputArr[j] = inputArr[j - 1];

                }
                inputArr[j] = temp;
                printArray(inputArr);
            }

    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        int [] inputArr = new int [n];

        for (int i=0; i <n;i++){
            inputArr[i] = in.nextInt();
        } // filled array

        //printArray(inputArr);

        insertIntoSorted(inputArr);

    }


}
