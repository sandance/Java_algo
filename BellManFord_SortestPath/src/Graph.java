/**
 * Created by nazmul on 2/20/15.
 */
public class Graph {
    public int V,E; // vertex and edges
    public Edge [] edge; // Graph is represented as a array of edges

    // constructor
    Graph (int x,int y) {
        this.V = x;
        this.E = y;

        edge =  new Edge[y];
    }
};



