import java.io.*;
import java.util.*;

public class Fibonacci_Numbers {

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

    public static long special_fibonacci(int a, int b, int n){
        long [] fibo = new long [n+1];

        fibo[0] = a;
        //fibo[1] = (int) Math.pow((double) b,2.0);
        fibo[1] = b;

        for(int i=2;i<=n;i++){
            fibo[i] = fibo[i-2] + (int) Math.pow((double)fibo[i-1],2.0);
        }
        return fibo[n-1];

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();

        assert (a >= 0 && a <= 2);
        assert (b >= 0 && b <= 2 );

        int n = in.nextInt();

        assert (n >= 3 && n <= 20);

        long fifth_term = special_fibonacci(a,b,n);

        System.out.println(fifth_term);


    }

}