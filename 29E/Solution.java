import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;



public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] nm = s.readLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);


        List<Integer> [] graph = new List[n];

        for(int i=0;i<n;i++)
                graph[i] = new ArrayList<Integer> ();

        for(int i=0;i<m; i++) {
                String [] l = s.readLine.split(" ");
                int a = Integer.valueOf(l[0]) -1;
                int b = Integer.valueOf(l[1]) -1;
                graph[a].add(b);
                graph[b].add(a);

        }


        // Input are are all taken , now time to solve the problem

        boolean [][][] dp = new boolean [2][n][n];
        int [][][] dp_prev = new int [2][n[n];
        int [] q = new int [500000];
        int qh = 0;
        int qt = 0;

        dp[0][0][n-1] = true;

        q[qt++] = 0;
        q[qh++] = 0;
        q[qt++] = n-1;



    }

}