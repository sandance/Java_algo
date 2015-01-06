import java.io.*;
import java.util.*;

public class Palindrome_check {

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



    /**
     *
     * @param str
     * @return int
     */
    public static int palindrome(String str){
        String reverse="";
        String original = str;
        int index=0;

        for(int i=original.length() -1; i >= 0 ; i--){
            reverse = reverse + original.charAt(i);
        }

        if (original.equals(reverse)){
            index=-1;
            return index;

        }else {
            // if they are not equal
            char [] ori = original.toCharArray();
            char [] rev = reverse.toCharArray();
            for(int i=0;i<original.length();i++){
                if(ori[i] != rev[i]) {
                    index = i;
                    break;

                }
                //return index;
            }
        }

        return index;

    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        int n = in.nextInt();


        /**
         * For each line check first whether it is palindorm or not
         * then check how you can make it a palindrome
         */
        for(int i=0; i<n;i++){
            String input = in.nextLine();
            int index = palindrome(input);
            System.out.println(index);
        }


    }

}