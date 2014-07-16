import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Created by nazmul on 7/15/14.
 */

public class Solution {

    public ArrayList<ArrayList<Integer>> s;
    public int n;
    public boolean [] u;
    public ArrayList<Integer> r;


    public boolean dfs(int v1, int v2) {
        if (v1==v2) return false;
        if(u[v1]) // iff already visited
            return false;
        u[v1] = true;

        for(int i=0; i < s.get(v1).size(); i++) {
            if (dfs(s.get(v1).get(i),v2)) {
                r.add(v1);
                return true;

            }
        }
        return false;
    }



    public  void run ()  {
        Scanner br = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = br.nextInt();

        s = new ArrayList<ArrayList<Integer>> () ;

        for(int i=0;i<n;i++)
            s.add(new ArrayList<Integer>());

        for(int i=1;i<n;i++) {
            int a = br.nextInt();
            int b = br.nextInt();
            a--;
            b--;
            s.get(a).add(b);
            s.get(b).add(a);

        }

        // leaf order , which need to be visited
        r = new ArrayList<Integer>();
        ArrayList<Integer> x = new ArrayList<Integer> ();

        x.add(0);
        while(br.hasNextInt()) {
            x.add(br.nextInt() -1);
        }
        x.add(0);



        r.add(0);

        // display x

        for(int i=0; i < x.size(); i++)
            out.println(i + " " +x[i]+"\n");


        for(int i=x.size() -1 ; i>=1; i--){
            u = new boolean[n];
            dfs(x.get(i-1),x.get(i));

        }
        Collections.reverse(r);

        if(r.size()==2*n-1) {
            for (int i = 0; i < 2 * n - 1; i++) {
                if (i > 0)
                    out.print(" ");
                out.print(r.get(i) + 1);
            }
        }
        else
            out.println("-1");

        br.close();
        out.close();

    }


    public static void main(String[] args) throws Exception {
        new Solution ().run();

    }
}