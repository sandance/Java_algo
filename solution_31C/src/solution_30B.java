import sun.awt.AWTAccessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.util.*;


public class solution_30B {

    //static po

    static class Sort implements Comparable<Sort> {

        int x,y,ind;

        public Sort(int i,int j,int k){
            x=i;
            y=j;
            ind=k;

        }

        public int compareTo(Sort o) {

            //System.out.println(arg0);
            if ( y != o.y )
                return y - o.y;
            return x-o.x;

        }
    }



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

    } // Input Class Ends




    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        // Number of Groups

        int n = in.nextInt();

        Sort [] A = new Sort[n];

        for(int i=0;i< n;i++) {
            A[i] = new Sort(in.nextInt(),in.nextInt(),i);
        }

        Arrays.sort(A);


        boolean [] can = new boolean[n];

        int ans =0;

        for(int i=0;i< n;i++) {
                boolean  bad = false;
                for(int j=1;j<i;j++) {
                    if (A[j].x < A[j-1].y )
                        bad = true;

                }


        }




        out.close();

    }





}