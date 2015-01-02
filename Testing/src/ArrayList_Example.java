import java.io.*;
import java.util.*;

public class ArrayList_Example {

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

        /* Array List
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++)
            nums.add(i);

        System.out.println("Original list " + nums);
        Iterator <Integer> numsIter = nums.iterator();

        while (numsIter.hasNext()) {
            numsIter.next();
            numsIter.remove();
        }

        System.out.println("List after removing all elements" + nums);
        */


    }


}