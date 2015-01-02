import java.io.*;
import java.util.*;

public class ListIterator_Example {

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

        String palStr = in.next(); // take a string from command line
        List<Character> palindrome = new LinkedList<Character>();

        for (char ch : palStr.toCharArray())
            palindrome.add(ch);

        System.out.print("Input String is : " + palStr);

        ListIterator<Character> iterator = palindrome.listIterator();

        ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());

        boolean result = true;

        while(revIterator.hasPrevious() && iterator.hasNext()){
            if(revIterator.previous() != iterator.next()){
                result = false;
                break;
            }
        }

        if(result)
            System.out.println("Input String is palindrome");
        else
            System.out.println("Input string is not a palindrome");



    }

}