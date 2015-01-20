import java.io.*;
import java.util.*;

public class Triangle_traversal {
    /* Array of Array as no multidimentional array in java */
    public static int [][] triangle;

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


    /**
     * Using DP bottom up approach calculate the minimum path from top to bottom
     * @param lineCount
     * @return minValue
     */
    public static int triangle_DP(int lineCount){

        for(int i=lineCount-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle[i][j] += (triangle[i+1][j] < triangle[i+1][j+1]) ? triangle[i+1][j]: triangle[i+1][j+1] ;
            }
        }
        return triangle[0][0];

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        LineNumberReader lnr = new LineNumberReader(new FileReader(new File("input.txt")));
        lnr.skip(Long.MAX_VALUE);
        int lineCount = lnr.getLineNumber();
        lnr.close();

        System.out.println(lineCount);


        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        triangle = new int [lineCount-1][];

        for (int i=0;i < lineCount;i++){
            triangle[i] = new int[i+1];
            String [] line = br.readLine().split("\t");
            for(int j=0;j<=i;j++){
                System.out.println(line[j]);
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        int min_path = triangle_DP(lineCount);

        System.out.println(min_path);



    }

}