import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintStream;



/**
 * Created by nazmul on 9/4/14.
 */
public class P36D_games {
    static int k;

    public static boolean get(int n, int m){
        if (n<k || m <k){ // so at the beginning chess piece should be at first posiiotn , if only one space
            // is available
            return (n+m) ==1;

        }

        // cases like when n=2,m=2 and k=2




    }


    public static void main(String[] args)  throws IOException {

        Scanner sc = new Scanner(new File("input.txt"));
        PrintStream out = new PrintStream(new File("output.txt"));

        int t = sc.nextInt();
        k = sc.nextInt();

        for(int i=0;i<n;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            out.println (get(n-1,m-1) ? "+" : "-" );
        } // for loop ends here

    } // main ends here



}
