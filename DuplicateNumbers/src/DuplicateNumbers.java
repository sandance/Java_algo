import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.*;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.lang.System;
import java.util.*;


public class DuplicateNumbers {


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

    /*
    public int getSum(List<Integer> numbers){
        int sum = 0;

        for(int num: numbers){
            sum += num;
        }
    }

    */
    public void findDuplicateNumber(List<Integer> numbers) {
        //int highestNumber = numbers.size() - 1;
        //int total = getSum(numbers);

        //int duplicate = total -

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for (int num: numbers){
            if(set1.contains(num)){
                                set2.add(num);
            }else
                set1.add(num);

        }

        //print all duplicate elements

        for(int num: set2){
            if(set2.isEmpty()){
                return;
            }
            System.out.print(num+" ");
        }


    }




    public static void main(String[] args ) throws IOException {

        List<Integer> numbers = new ArrayList<Integer>();
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        for(int i=0;i <n;i++)
            numbers.add(in.nextInt());

        out.println("Enter duplicate Element");
        numbers.add(in.nextInt());

        DuplicateNumbers dp = new DuplicateNumbers();
        dp.findDuplicateNumber(numbers);


    }



}
