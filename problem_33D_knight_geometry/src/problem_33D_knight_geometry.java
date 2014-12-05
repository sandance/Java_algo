import java.io.*;
import java.util.*;


/**
 * Created by nazmul on 8/19/14.
 */
public class problem_33D_knight_geometry {

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st==null || ! st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e){
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


    } // end of input class



    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();


        int [][] loc = new int [n][2];

        for(int i=0; i < n; i++){
            loc[i][0] = sc.nextInt();
            loc[i][1] = sc.nextInt();
        } // enter all the coordinates


        boolean [][] in = new boolean[n][m];


        for(int i=0; i < m; ++i){

            int r = sc.nextInt() , cx = sc.nextInt() , cy = sc.nextInt();
            // radius, cx and cy co-ordinates

            for(int j=0; j < n;++j) {
                if (Math.pow(r, 2) > Math.pow((loc[j][0] - cx), 2) + Math.pow((loc[j][1] - cy), 2)) {
                    in[j][i] = true;
                }
            }

            int sum = 0;

            for(;k-->0;){
                int src = sc.nextInt() -1;
                int tgt = sc.nextInt() -1;

                for(int l=0; l < m; l++){
                    sum +=in[src][l] ^ in[tgt][l] ? 1 :0;
                }

                System.out.println(sum);


            }

        }

    }
}
