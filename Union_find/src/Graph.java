/**
 * Created by nazmul on 7/24/14.
 */
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
    int find(int parent[], int i){
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y){
        int xSet = find(parent, x);
        int ySet = find (parent, y);
        parent[xSet] = ySet;
    }

    // The main function to check whether a given graph contains
    // a cycle or not

    int isCycle(Graph graph){
        // Allocating memory for creating V subsets
        int [] parent = new int [graph.V];

        // Initialize all subsets as single element sets
        for(int i=0; i<graph.V; ++i){
            parent[i] = -1;
        }

        // Iterate through all edges of graph
        // find subsets of vertices for every edge
        // if both subsets are same, there is a cycle in Graph

        for(int i=0; i < graph.E; i++){
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if(x==y){
                return 1;
            }
            graph.Union(parent, x, y);
        }
        return 0;

    }



}
