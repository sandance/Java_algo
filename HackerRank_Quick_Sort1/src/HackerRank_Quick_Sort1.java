import java.io.*;
import java.util.*;

public class HackerRank_Quick_Sort1 {

    public static int [] inputArr;


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
     * Quick Sort Algorithms
     * @param args inputArr
     * @param args low
     * @param args high
     * @throws IOException
     * returns Sorted Array
     */



    public static void swap(int a, int b){
        int tmp = inputArr[a];
        inputArr[a] = inputArr[b];
        inputArr[b] = tmp;
    }


    public static void QuickSort(int low, int high){

        int lo = low;
        int hg = high;

        //int pivot = inputArr[low+(high-low)/2];
        int pivot = inputArr[low];

        while ( lo <= hg){
            while(inputArr[lo] < pivot)
                lo++;
            while(inputArr[hg] > pivot)
                hg--;

            if(lo <= hg) {
                swap(lo, hg);
                lo++;
                hg--;
            }
        }

        //if (low < hg)
        //    QuickSort(low,hg);
        if(lo < high)
            QuickSort(lo,high);

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        inputArr = new int [n];
        for(int i=0; i<n;i++)
            inputArr[i] =in.nextInt();


        QuickSort(0,inputArr.length -1);
        for(int i=0;i<n;i++ )
            System.out.print(inputArr[i]+" ");

    }

}