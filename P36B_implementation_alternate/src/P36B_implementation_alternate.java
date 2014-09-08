import java.io.*;
import java.util.*;



/**
 * Created by nazmul on 9/4/14.
 */


class P36B_implementation_alternate {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("input.txt"));
        PrintStream out = new PrintStream(new File("output.txt"));

        int n = sc.nextInt();
        int k = sc.nextInt();

        char [][] input = new char[n][n];
        char [][] prev;
        char [][] next;

        for(int i=0;i<n;i++){
            String st = sc.next();
            for(int j=0; j <n;j++){
                input[i][j] = st.charAt(j);
            }


        } // input is taken

        int dim=n;
        prev = new char[dim][dim];
        for(int i=0; i<k;i++){
            // For each iteration
            dim *=n;
            next = new char [dim][dim];

            for(int r=0; r < dim; r++ ){
                for(int c=0; c < dim; c++){
                    if(input[r/n][c/n] == '.'){
                        next[r][c] = input[r%n][c%n];

                    }else
                        next[r][c]='*';
                }
            }
        }



    }
}