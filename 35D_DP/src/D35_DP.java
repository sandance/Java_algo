import java.io.*;
import java.util.*;


/**
 * Created by nazmul on 8/27/14.
 */
public class D35_DP {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static  int N;
    private static int X;

    private static int[] consumption;


    static void solve(){

        int tot = X;

        for(int i=0;i<N;i++) {
             consumption[i] = consumption[i] * (N - i);

        }

        Arrays.sort(consumption);

        int cnt =0;

        for(int i=0;i<N;i++){
            if (tot < consumption[i]){
                break;
            }
            cnt +=1;
            tot -= consumption[i];

        }
        out.print(cnt+"\n");

    }







    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String next() throws IOException {
        while( st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                return null;

            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }


    public static void main(String[] args) throws IOException {
       try {
           InputStream input = System.in;
           OutputStream output = System.out;

           br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
           out = new PrintWriter(new PrintStream(new File("output.txt")));

           N = nextInt();
           X = nextInt();
           consumption = new int[N];

           for(int i=0;i<N;i++){
               consumption[i] = nextInt();
           }
           solve();
           //out.write(result);
           br.close();
           out.close();
           } catch(Exception e){
           e.printStackTrace();
       }

    }

}
