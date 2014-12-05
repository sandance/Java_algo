import java.io.*;
import java.util.*;
import java.lang.String;



/**
 * Created by nazmul on 11/26/14.
 */
public class bfs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String [] nm = br.readLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        List<Integer> [] graph = new List[n];

        for (int i=0; i<n;i++){
            graph[i] = new ArrayList<Integer>();

        }

        for(int i=0; i<m;i++){
            String [] lo = br.readLine().split(" ");
            int a = Integer.valueOf(lo[0]);
            int b = Integer.valueOf(lo[b]);

            graph[a].add(b);
            graph[b].add(a);



        }


        boolean []  visited = new boolean[n];

        for (int i=0;  )






    }
}
