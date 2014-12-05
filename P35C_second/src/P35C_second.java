import java.io.*;
import java.io.IOException;

import java.util.*;
import java.awt.Point;





/**
 * Created by nazmul on 8/27/14.
 */
public class P35C_second {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    /*
    static int [][] moves = new int [][] {{0,1}, {1,0} , {-1,0}, {0,-1} };

    static void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        int [][] order = new int [n][m];
        boolean  [][] visited = new boolean [n][m];

        Queue<Integer> queue = new LinkedList<Integer>();

        Set<String> set = new HashSet<String>();

        for(int i=0; i < k; i++) {
            int x = nextInt() -1;
            int y = nextInt() -1;
            order[x][y] = 1;
            queue.add(new Integer[] {x,y});
            set.add(x + " " +y);
        }




    } */



    static int n,m,k;

    static void solve() throws Exception {

         n = nextInt();
         m = nextInt();
        boolean visited [][] = new boolean[n][m];

         k = nextInt();

        Queue<Point> queue = new LinkedList<Point>();

        Point last = new Point(0,0);

        while(k-- > 0){

            int x = nextInt() -1;
            int y = nextInt() -1;
            queue.add(new Point(x,y));
            visited[x][y] = true;
        }



        // Done with all inputs


        while(!queue.isEmpty()) {

            Point frnt = queue.poll();

            for (int i = frnt.x - 1; i <= frnt.x + 1; ++i) {
                for (int j = frnt.y - 1; j <= frnt.y + 1; ++j) {
                    if (val(i, j) && !visited[i][j] && (frnt.x == i || frnt.y == j)) {
                        queue.add(new Point(i, j));
                        last = new Point(i, j);
                        out.println(last.x + 1 + " " + (last.y + 1) + "\n");
                        visited[i][j] = true;

                    }
                }
                out.write(last.x + 1 + " " + (last.y + 1) + "\n");
                out.flush();

            }

        }

    }

    static boolean val(int x,int y) {
        return x>=0 && x <n && y >= 0 && y <m;
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




    public static void main(String[] args)  {

        try {

            InputStream input = System.in;
            OutputStream output = System.out;

            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
            out = new PrintWriter(new PrintStream(new File("output.txt")));

            solve();
            out.close();
            br.close();


        } catch (Throwable t) {
            t.printStackTrace();
        }

    }




}
