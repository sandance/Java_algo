import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cutting_Rod_Recursive {

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

    public static int cut_rod_recv(int [] price, int n){

        if (n <= 0) {
            return 0;
        }

        int max_value = Integer.MIN_VALUE;

        /*
        Recursively cut the Rod in different pieces and compare different configurations

         */
        for (int i=0; i < n;i++){
            max_value = Math.max(max_value, price[i] + cut_rod_recv(price, n-i-1 ));
        }


        return max_value;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        //System.out.println("Enter total number of elements\n");
        int n = in.nextInt();



        int [] price = new int [n];

        for(int i=0;i<n;i++){

            price[i] = in.nextInt();
        }

        int val = cut_rod_recv(price,n);



        System.out.println("Maximum value : "+val);



    }
}
