import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;



/**
 * Created by nazmul on 7/16/14.
 */

public class Program_29D {

    int n;
    ArrayList<Integer> order;
    boolean [] vis;
    int [][] adj;

    public Program_29D() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new int[n + 1][n + 1];

        // adjacency matrix method

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            adj[x][y] = 1;
            adj[y][x] = 1;


        }
        String l = sc.nextLine();
        String[] la = l.split(" ");
        ArrayList<Integer> leaves = new ArrayList<Integer>();

        for (int i = 0; i < la.length; i++) {
            leaves.add(Integer.parseInt(la[i]));

        }
        sc.close();


        leaves.add(0, 1); // added 1 as the first element in leaves arraylist
        leaves.add(1); // added 1 as the last element in leaves

        order = new ArrayList<Integer>();
        order.add(1);


        for (int i = leaves.size() - 1; i >= 1; i++) {
            vis = new boolean[n + 1];
            DFS(leaves.get(i - 1), leaves.get(i));

        }

        Collections.reverse(order);

        if (order.size() == 2 * n - 1) {
            for (int i = 0; i < order.size(); i++) {
                System.out.print(order.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }



    boolean DFS(int start , int target) {
        if(start == target) {
            return true;
        }
        if(vis[start]) //iff already visited
            return false;
        vis[start] = true;

        for(int i=1; i <= n;i++){
            if(adj[start][i] ==1) { // Iff there is an edge
                 if(DFS(i,target)) {
                     order.add(start);
                     return true;
                 }
            }
        }
        return false;
    }

public static void main(String[] args) {
    new Program_29D();
}



}
