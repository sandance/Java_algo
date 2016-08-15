/**
 * Created by NIslam on 8/14/16.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by NIslam on 8/13/16.
 */
public class Scanner {
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