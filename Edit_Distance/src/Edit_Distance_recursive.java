import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 5/2/17.
 */
public class Edit_Distance_recursive {

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

    public static int min(int x, int y, int z){
        return Math.min(Math.min(x,y),z);
    }

    public static int EditDistanceRecv(String strA, String strB, int m, int n) {


        // If m ==0 , that means first string is empty , so copy the other string
        if (m==0) return n;

        // If n == 0 , that means 2nd string is empty ,  so copy the other string
        else if (n==0) return m;
        //
        else if (strA.charAt(m-1) == strA.charAt(n-1)) {
            return EditDistanceRecv(strA, strB, m-1, n-1);
        }

        // if last characters are not the same , consider all three operations on last
        // character of first string. Recursively computer minimum of all three operations
        // and take minimum of three

        return 1 + min(EditDistanceRecv(strA, strB, m, n-1), // insert
                EditDistanceRecv(strA, strB, m-1, n), // Remove
                EditDistanceRecv(strA, strB, m-1, n-1)); // replace



    }


    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String stringA = in.next();
        String stringB = in.next();

        int m = stringA.length();
        int n = stringB.length();


        int min_distance = EditDistanceRecv(stringA,stringB,m,n);
        System.out.println(min_distance);
    }
}
