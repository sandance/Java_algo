import java.io.*;
import java.util.*;



/**
 * Created by nazmul on 9/2/14.
 */

public class P36C_geometry {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static String next() throws IOException {
        while( st== null || !st.hasMoreTokens() ){
            String line = br.readLine();
            if(line == null)
                return null;

        st= new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws  IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws  IOException {
        return Double.parseDouble(next());
    }

    private static class Bowl {
        double h, r1, r2, p, tan;
        Bowl(double h, double r1, double r2){
            this.h = h;
            this.r1 = r1;
            this.r2 = r2;
        }

        double tan() {
            if(tan==0)
                tan = h / (r2 - r1);
            return tan;
        }

        double put ( Bowl o){
            double result = h - o.h + (o.r2 - r2) * (o.r2 > r2 ? o.tan() : tan() );
            result = Math.max(0, result);

            if ( o.r1 > r1 )
                result = Math.max( (o.r1 - r1 ) * tan(), result);

            result = Math.max(h,result);
            return p + result;

        }
    }

    public static void solve() throws  IOException{
        int n= nextInt();
        assert n > 0;

        LinkedList<Bowl> bowls = new LinkedList<Bowl>();
        double result=0;

        for(int i=0; i< n;i++){

            double h = nextDouble();
            double r = nextDouble();
            double R = nextDouble();

            assert h > 0 && r > 0 && R >0 && r < R;

            Bowl bowl = new Bowl(h,r,R);
            double max = 0;
            for(Iterator<Bowl> iterator = bowls.descendingIterator(); iterator.hasNext();){
                Bowl b = iterator.next();
                if ( max < b.p + b.h)
                    max = Math.max(b.put(bowl), max);
                else
                    iterator.remove();
                }
            bowl.p = max;
            bowls.add(bowl);
            result = Math.max(bowl.p + bowl.h, result);

        }

        System.out.println(result);

    }


    public static void main(String[] args) {

        try {
            InputStream input = System.in;
            OutputStream output = System.out;

            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
            out = new PrintWriter(new PrintStream(new File("output.txt")));

            solve();
            out.close();
        } catch(Throwable t){
            t.printStackTrace();
        }
    }

}
