import java.io.*;
import java.util.*;
import java.lang.*;



/**
 * Created by nazmul on 8/6/14.
 */
public class ReverseString {

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

    String reverse ="";

    public String reverseString(String str){

        if(str.length() ==1 ){
            return str;
        } else {
            reverse +=str.charAt(str.length() -1) + reverseString(str.substring(0,str.length()-1));
            return reverse;
        }

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner();
        ReverseString rs = new ReverseString();


        System.out.println("Enter any String \n");
        String original = sc.next();

        System.out.println("Result "+ rs.reverseString(original));

    }
}