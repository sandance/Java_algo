/**
 * Created by NIslam on 8/17/16.
 */

import java.util.*;

public class Graph {
    public int V,E;
    Edge [] edge;

    //Edge edge = new Edge[];

    Graph(int v, int e){
        V=v;
        E=e;

        edge = new Edge[E];
        for (int i=0;i<E;i++){
            edge[i] = new Edge();
        }

    }


    // A utility function to find the subset of element i
    int find(subset [] subsets, int i){
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // A utility function to do union of two subsets
    void Union(subset [] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find (subsets, y);

        // attach smaller rank tree under root of high
        // rank tree
        //parent[xSet] = ySet;

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
            // if the ranks are same , then make one as root
            // and increment its root by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }

    }

    // The main function to check whether a given graph contains
    // a cycle or not

    public void kruskal(Graph graph) {
        // Allocating memory for creating V subsets
        Edge[] result = new Edge[graph.V];
        for (int i=0;i< graph.V;i++){
            result[i] = new Edge();
        }
        // sort the edges
        Arrays.sort(graph.edge);

        // allocate memory to create V subsets
        subset[] subsets = new subset[graph.V];
        for (int i = 0; i < graph.V; i++)
            subsets[i] = new subset();
        //List<subset> [] subsets = new List[graph.V];

        // Initialize all subsets as single element sets
        for (int i = 0; i < graph.V; i++) {

            //System.out.println("vextex: " + i);
            subsets[i].parent = i;
            subsets[i].rank = 0;

        }

        int noEdge = 0, counter = 0;


        // number of edges has to be V - 1
        while (noEdge < graph.V ) {
            // step 2 : pick the smallest edge
            Edge nextEdge = graph.edge[noEdge++];
            System.out.println("source of edge: "+nextEdge.src+" end of edge:"+ nextEdge.dest);


            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // if including this edge does not cause cycle
            // increment the index
            if (x != y) {
                result[counter++] = nextEdge;
                Union(subsets, x, y);
            }
            // else discard the next edge if they are the same
        }

        System.out.println("Following are the edges of MST");
        for(int i=0; i< counter ; i++){
            System.out.println(result[i].src+"---"+result[i].dest+"----"+result[i].weight);
        }


    }

}
