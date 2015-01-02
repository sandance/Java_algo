import java.io.*;
import java.util.*;

public class HashSet_RemoveDuplicates {

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

        String toungeTwister = "I feel, a feel, a funny feel, a funny feel I feel,if you feel the feel I feel, I feel the feel you feel";
       // Set <String> words = new HashSet<String> ();
            Set <String> words = new TreeSet<String> ();


        for (String word:  toungeTwister.split("\\W+"))
                    words.add(word);

        System.out.println("The tounge twister is: " +  toungeTwister);
        System.out.println("The words used were: ");
        //Iterator<String> iterator = words.Iterator();

        System.out.println(words);

    }

}