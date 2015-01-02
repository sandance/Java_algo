import java.io.*;
import java.util.*;


class Splqueue {
    private Deque<String> spLQ = new ArrayDeque<String>();

    void addInQueue(String customer) {
        spLQ.addLast(customer);
    }

    void reoveInQueue() {
        spLQ.removeFirst();
    }

    void removeBack() {
        spLQ.removeLast();
    }

    void printQueue() {
        System.out.println("Special queue contains: " + spLQ);
    }
}


public class Deque_SplQueueTest {


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
        Splqueue splq = new Splqueue();
        splq.addInQueue("Harrison");


        splq.addInQueue("Starr");

        splq.printQueue();
        splq.removeBack();
        splq.printQueue();
    }

}