/**
 * Created by NIslam on 8/14/16.
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

    int isCycle(Graph graph){
        // Allocating memory for creating V subsets
        subset [] subsets = new subset[graph.V];
        for (int i=0;i<graph.V; i++)
            subsets[i] = new subset();
        //List<subset> [] subsets = new List[graph.V];

        // Initialize all subsets as single element sets
        for(int i=0; i< graph.V; i++){

            System.out.println("vextex: "+i);
            subsets[i].parent = i;
            subsets[i].rank = 0;

        }

        // Iterate through all edges of graph
        // find subsets of vertices for every edge
        // if both subsets are same, there is a cycle in Graph

        for(int i=0; i < graph.E; i++){
            int x = graph.find(subsets, graph.edge[i].src);
            int y = graph.find(subsets, graph.edge[i].dest);

            if(x==y){
                return 1;
            }
            graph.Union(subsets, x, y);
        }
        return 0;

    }



}