import java.io.*;
import java.util.*;

/**
 * Created by nazmul on 8/7/14.
 */
public class DuplicateElements {

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

    public static int [] removeDuplicates(int [] input) {
            int j=0;
            int i=1;

            //return if the array length is less than 2

            if(input.length < 2)
                return input;

            while( i < input.length ) {

                if (input[i] == input[2])
                    i++;
                else
                    input[++j] = input[i++];
            }

            int[] output = new int[j + 1];

            for (int k = 0; k < output.length; k++)
                output[k] = input[k];

            return output;
    }


    public static void main(String [] args) {
        Scanner sc = new Scanner();
        System.out.println("Enter number of elements\n");
        int n = sc.nextInt();

        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();

        Arrays.sort(input);


        int[] output = removeDuplicates(input);

        for (int i : output)
            System.out.println(i + " ");


    }
}
