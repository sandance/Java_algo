import java.util.*;
import java.io.*;
import java.lang.*;


/**
 * Created by nazmul on 8/6/14.
 */
public class ReverseNumber {


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


    public int reverseNumber (int number) {

        int reverse=0;

        while( number !=0 ){
            reverse = (reverse *10) + (number%10);
            number = number / 10;
        }
        return reverse;
    }


    public static void main(String [] args) throws IOException {

        ReverseNumber rn = new ReverseNumber();
        Scanner sc = new Scanner();


        int n= sc.nextInt();

        System.out.println("Result : "+ rn.reverseNumber(n));

    }
}

