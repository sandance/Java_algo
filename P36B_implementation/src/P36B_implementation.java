

import java.io.*;
import java.util.*;



/**
 * Created by nazmul on 9/3/14.
 */



public class P36B_implementation {

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

    public static char get(char[][] cs, int i,int j,int n,int k){
       return k==0 ? '.' : get(cs,i/n,j/n,n,k-1) == '*' ? '*' :
    }

    public static void solve() throws IOException {
        int n=nextInt();
        int k=nextInt();

       int m = (int) Math.pow(n,k);
       char [][] cs= new char[n][];
       char [][] result = new char[m][m];

        for(int i=0;i<n;i++){
            cs[i] = next().toCharArray();
        }

        for(int i=0;i<k;i++){
            for(int j=0;j<m;j++){
                result[i][j] = get(cs,i,j,n,k);
            }
        }

    }


    public static void main(String[] args) throws IOException {

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
            out = new PrintWriter(new PrintStream(new File("output.txt")));
            solve();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
