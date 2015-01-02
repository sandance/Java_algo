import java.io.*;
import java.util.*;

public class QueueTest {

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

        Queue<String> loginSequence = new LinkedList<String>();

        loginSequence.add("Harrison");
        loginSequence.add("McCartney");
        loginSequence.add("Star");
        System.out.println("The login sequence is: " + loginSequence);

        while(!loginSequence.isEmpty())
            System.out.println("Removing "+loginSequence.remove());

    }

}