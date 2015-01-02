import java.io.*;
import java.util.*;

public class Palindrome {

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

        String inpStr = in.next();

        List<Character> palindrome = new LinkedList<Character>();

        for(char ch: inpStr.toCharArray())
                palindrome.add(ch);


        ListIterator<Character> iterator = palindrome.listIterator();
        ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());

        boolean result = true;

        while(revIterator.hasPrevious() && iterator.hasNext()){
            if(revIterator.previous() != iterator.next()){
                result = false;
                break;

            }
        }

        if (result)
            System.out.println("It is a Palindrome string \n");
        else
            System.out.println("It is not a Palindrome string\n");
    }

}