import java.io.*;
import java.util.*;

public class Recursive_Min_Cost_Path {

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


    public static int minCost(int [][] cost, int x, int y){
        if ( x < 0 || y < 0)
            return 100000;
        else if (x==0 && y==0)
            return cost[x][y];
        else
            return cost[x][y] + Math.min(Math.min(minCost(cost,x,y-1),minCost(cost,x-1,y)),minCost(cost,x-1,y-1));
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        /*
        try {
            FileInputStream fis = new FileInputStream(new File("text.txt"));

            int content;
            while((content = fis.read()) != -1){
                System.out.println(content);
            }
        } catch (IOException e){
                e.printStackTrace();
        } finally {
            fis.close();
        }
        */

        int [][] input = {
            {1,2,3}, {4,8,2}, {1,5,3} };

        int n=3,m=3;

        int min_cost = minCost(input,2,2);
        System.out.println(min_cost);

    }

}