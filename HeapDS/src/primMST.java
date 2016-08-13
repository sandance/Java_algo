import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by NIslam on 8/12/16.
 */
public class primMST {

    public static void printArr(int [] array){
        for (int i=0;i<array.length;i++){
            System.out.println(i);
        }
    }


    public static void printMST(int[] parent, int V, HashMap<Integer, HashMap<Integer, Integer>> graph) {
        System.out.println("Edge     Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " -- " + i + "    " + graph.get(i).get(parent[i]));
        }


    }

    public static class CostNode {
        int node;
        int cost;

        public CostNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        // number of vertices
        //int n = Integer.parseInt(br.readLine());
        String[] nm = br.readLine().split(" "); //take vertix and enge numbers
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);
        HashMap<Integer, HashMap<Integer, Integer>> edgeMap = new HashMap<Integer, HashMap<Integer, Integer>>();

        //int w = Integer.valueOf(nm[2]);


        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();

            if (edgeMap.containsKey(u)) {
                edgeMap.get(u).put(v, weight);

            } else {
                HashMap<Integer, Integer> edge = new HashMap<Integer, Integer>();
                edge.put(v, weight);
                edgeMap.put(u, edge);
            }

            if (edgeMap.containsKey(v)) {
                edgeMap.get(v).put(u, weight);
            } else {
                HashMap<Integer, Integer> edge = new HashMap<Integer, Integer>();
                edge.put(u, weight);
                edgeMap.put(v, edge);
            }


        } // graph is formed


        boolean[] visited = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];
        Heap heap = new Heap(n);


        for (int i = 0; i < n; i++) {
            visited[i] = false;
            // Key values used to pick minimum weight edge in cut
            key[i] = Integer.MAX_VALUE;

        }

        int numVisited = 0;

        System.out.println("Enter the vertex number from which you want MST");
        int S = sc.nextInt();


        key[S] = 0;
        parent[S] = 0;

        heap.insert(key[S]);

        while (numVisited < n) {

            int minNode = heap.remove().getKey();
            System.out.println("heap top"+minNode);

            if (!visited[minNode]) {
                visited[minNode] = true;
                numVisited++;


                // look at the adjacent vetices
                for (int neighbor : edgeMap.get(minNode).keySet()) {
                    if (!visited[neighbor] && edgeMap.get(minNode).get(neighbor) < key[neighbor]) {
                        parent[neighbor] = minNode;
                        key[neighbor] = edgeMap.get(minNode).get(neighbor);
                        //costQueue.add(new CostNode(neighbor, key[neighbor]));
                        heap.insert(key[neighbor]);
                    }

                }
                printArr(parent);

                //printMST(parent, n, edgeMap);
            }
        }
    }
}