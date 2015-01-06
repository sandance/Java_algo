import java.io.*;
import java.util.*;


public class pangrams {

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

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String str = in.nextLine();

        HashSet set = new HashSet();

        char [] pangram_arr = str.toLowerCase().toCharArray();
        //System.out.println(pangram_arr.length);

        for(int i=0; i < pangram_arr.length ; i++){
            if (pangram_arr[i] ==' ')
                continue;
            set.add(pangram_arr[i]);
        } // inserting element into array

        //System.out.println(set.size());

        if (set.size()==26){
            System.out.println("pangram");
        }else
            System.out.println("not pangram");



    }

}