import java.io.*;
import java.util.*;

/**
 * Created by NIslam on 8/17/16.
 */
public class FloydWarshall_AllPair {
    public static int n, m;
    public static int [][] dist = new int [n][m];

    public static void FloydWarshall(int [][] graph){

        // copy the array

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = graph[i][j];
            }
        }

        // Add all vertices one by one to the set of intermediate vertices

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if( dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    public static void printSolution(int [][] dist){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (dist[i][j]== Integer.MAX_VALUE)
                    System.out.print("INF");
                else
                    System.out.print(dist[i][j]+ "  ");

            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        int [][] graph = new int [n][m];

        // pre-occupy  them with INF
        System.out.println("Enter weights of the graph, for INF enter -1");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("For vertex: "+i+"And edge"+j);
                graph[i][j] = in.nextInt();

                if (graph[i][j] == -1)
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }

        // fix the graph


        //
        FloydWarshall(graph);
        printSolution(dist);

    }
}
