/**
 * Created by NIslam on 7/26/16.
 */

import java.io.*;
import java.util.*;

public class integet_increment {

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

    public static List<Integer> plusone (List<Integer> A) {
        int n = A.size() - 1;

        A.set(n, A.get(n)+1);
        for (int i=n; i>0 && A.get(i) == 10; --i){
            A.set(i,0);
            A.set(i-1; A.get(i-1) +1);
        }

        if (A.get(0) == 10){
            // Need additional digit as the most significant digit and add a digit
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;
    }

    public static void main(String [] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        //List<Integer> output;

        //int number = in.nextInt();
        String str = in.nextLine();
        char [] array = str.toCharArray();

        List <Integer> list = new ArrayList<>(str.length());
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            list.add(int(str.valueOf(Character.getNumericValue(c))));

        }


        List<Integer> output = plusone(list);

    }

}
