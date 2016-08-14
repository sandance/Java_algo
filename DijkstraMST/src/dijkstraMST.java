/**
 * Created by NIslam on 8/13/16.
 */
import java.io.*;
import java.util.*;


public class dijkstraMST {

    public static void printMST(int[] dist, int V, HashMap<Integer, HashMap<Integer, Integer>> graph) {
        System.out.println("Edge     Weight");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t"+ dist[i]) ;
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

    public static void printGraph(HashMap<Integer, HashMap<Integer, Integer>> graph, int V, int E) {
        for (int i = 0; i < V; i++) {
            for (int edge : graph.get(i).keySet()) {
                System.out.println("Vertex: " + graph.get(i) + "  weight:" + graph.get(i).get(edge));
            }
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

        // print the graph
        printGraph(edgeMap, n, m);
        // edge weight comparator

        PriorityQueue<CostNode> costQueue = new PriorityQueue<CostNode>(new Comparator<CostNode>() {
            @Override
            public int compare(CostNode o1, CostNode o2) {
                return (o1.cost - o2.cost);
            }
        });

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] mstSet = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
            // Key values used to pick minimum weight edge in cut
            dist[i] = Integer.MAX_VALUE;
            mstSet[i] = false;

        }

        int numVisited = 0;

        System.out.println("Enter the vertex number from which you want MST");
        int S = sc.nextInt();

        costQueue.add(new CostNode(S, 0));
        dist[S] = 0;
        parent[S] = -1;

        while (numVisited < n) {
            CostNode costNode = costQueue.poll();
            int minNode = costNode.node;
            mstSet[minNode] = true;

            System.out.println("MinNode: " + minNode);
            if (!visited[minNode]) {
                visited[minNode] = true;
                numVisited++;


                // look at the adjacent vetices
                for (int neighbor : edgeMap.get(minNode).keySet()) {
                    if (!mstSet[neighbor] && dist[minNode] != Integer.MAX_VALUE && dist[minNode] + edgeMap.get(minNode).get(neighbor) < dist[neighbor]) {
                        System.out.println("Processing :" + neighbor + "\t" + edgeMap.get(minNode).get(neighbor));
                        //parent[neighbor] = minNode;
                        dist[neighbor] = dist[minNode] + edgeMap.get(minNode).get(neighbor);
                        costQueue.add(new CostNode(neighbor, dist[neighbor]));
                    }

                }

            }
        }

        printMST(dist, n, edgeMap);


    }

}














