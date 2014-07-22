import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.*;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//@author pttrung


public class string_30B {

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens() ) {
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
            }
            catch(Exception e) {
                throw new RuntimeException();
            }
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String val = in.next();

        if (val.contains("@")) {

            StringBuilder result = new StringBuilder();
            boolean found = true;

            StringBuilder pre =   new StringBuilder();

            for(int i=0; i< val.length();i++) {
                if(val.charAt(i) == '@') {
                    if(pre.length()==0 || i+1 >= val.length() || val.charAt(i+1) == '@') {
                        found = false;
                        break;
                    } else {
                        if (result.length() > 0) {
                            result.append(",");
                        }
                        result.append(pre).append("@").append(val.charAt(i+1));
                        i++;
                        pre = new StringBuilder();
                    }
                } else {
                    pre.append(val.charAt(i));
                }
            }

            result.append(pre);

            if(found){
                out.println(result.toString());
            } else {
                out.println("No Solution");
            }
        } else {
            out.println("No Solution");

        }

        out.close();
    }
    // out.close();


}