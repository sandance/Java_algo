import java.io.*;
import java.util.*;

public class StringParsing1 {

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

        String quote = "Never lend books-nobody ever returns them!";
        String [] words = quote.split(" ");

        for (String word: words)
            System.out.println(word);


        String str = "c:\\work\\programs\\parser";
        String [] dirList = str.split("\\\\");
        for(int i =0; i < dirList.length ; i++)
            System.out.println(dirList[i]);

    }

}