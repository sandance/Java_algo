import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.lang.System;
import java.util.*;


public class QuickSort {

    // Global variables

    public int [] array;
    public int length;




    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    // End of Input Class

    private void exchangeNumbers(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void qsort(int low, int high){

        int lo = low;
        int hg = high;

        int pivot = array[lo+(hg - lo) / 2];

        // Divide into two arrays

        while( lo <= hg) {

            /**
             * In each iteration, we will identify a number from left side which is greater then
             * the pivot value, and also we will identify a number from right side which is less
             * than pivot value . Once the search is done , then we exchange both numbers
             *
             */
            while (array[lo] < pivot) {
                lo++;
            }

            while (array[hg] > pivot) {
                hg--;
            }


            if (lo <= hg) {

                exchangeNumbers(lo, hg);
                // move index to next position on both sides

                lo++;
                hg--;

            }
        }
            // call qsort() method recursively

            if(low < hg)
                qsort(low,hg);
            if ( lo < high)
                qsort(lo,high);

    }

    public void sort (int [] inputArr){

        if(inputArr == null || inputArr.length ==0 ) {
            return;
        }

        array = new int[inputArr.length];
        this.array= inputArr;
        length = inputArr.length;

        qsort(0,length -1);

        for(int i=0; i< length; i++){
            System.out.print(array[i]+ " ");
        }



    }


    public static void main(String[] args) throws  IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Number of Elements\n");
        int n = in.nextInt();


        int [] input = new int [n];

        for(int i=0; i<n;i++){
            input[i] = in.nextInt();
        }

        QuickSort qs = new QuickSort();

        qs.sort(input);



        out.close();

    }

}