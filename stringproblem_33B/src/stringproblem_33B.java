import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.lang.*;



/**
 * Created by nazmul on 8/13/14.
 */
public class stringproblem_33B {


    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    // End of Input Class


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner();

        String A = sc.next();
        String B = sc.next();

        int n = sc.nextInt();

        if (A.length() != B.length()) {
            System.out.println("-1");
            return;
        }


        char a = 'a';
        int INF = (int) 1e9;
        int [][] p = new int[26][26];

        for (int i = 0; i < p.length  ; i++){
            Arrays.fill(p[i], INF);
            p[i][i] = 0; // if both characters are same , then no weight
        }

        for(int i=0; i < n; i++){
            int x = sc.next().charAt(0) - a;
            int y = sc.next().charAt(0) - a;

            int k = sc.nextInt();

            p[x][y] = Math.min(p[x][y], k);

        }

        for(int k=0; k< 26; k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    p[i][j] = Math.min(p[i][j],p[i][k]+p[k][i]);
                }
            }
        }


        StringBuilder res = new StringBuilder("");
        boolean fail = false;

        int acc = 0;

        for(int i=0;i< A.length(); i++){
            int mn= INF;
            char letter =0;

            int q = A.charAt(i) -a;
            int r = B.charAt(i) -a;

            for(int j=0;j<26; j++){

                int num1 = p[q][j] - a;
                int num2 = p[r][j] - a;

                if(num1+num2 < mn){
                    mn = num1+num2;

                    letter = (char) (j+a);


                }
            }

            if (mn == INF){
                fail = true;
                break;
            }

            res.append(letter);
            acc += mn;
        }

        if(fail)
            System.out.println("-1");
        else {
            System.out.println(acc);
            System.out.println(res.toString());
        }


    }

}
