import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by NIslam on 8/25/16.
 */
public class DirectedGraph {
    public static int numVertices;
    public static Vertex [] vertices;
    public static ArrayList<LinkedList<Vertex>> adjLists;
    public static Edge [][] adjMatrix;


    public DirectedGraph(int V){
        numVertices = V;

        vertices = new Vertex[numVertices];
        adjLists = new ArrayList<LinkedList<Vertex>>();
        adjMatrix = new Edge[numVertices][numVertices];

        // initially all adjacency lists to be empty
        // initiate all entries in adjMatrix to be null

        for(int u=0; u < numVertices ; u++){
            adjLists.add(new LinkedList<Vertex>());
            for(int v=0; v < numVertices ; v++) {
                adjMatrix[u][v] = null;
            }

        }

    }
    // add a new vertex with specified label
    public Vertex addVertex ( int label){
        Vertex  u = new Vertex(label);
        vertices[label] = u;
        return u;
    }

    public void addEdge(Vertex sourceEndpoint, Vertex targetEndpoint) {
        Edge e = new Edge(sourceEndpoint, targetEndpoint);
        adjLists.get(sourceEndpoint.getLabel()).addLast(targetEndpoint);
        adjMatrix[sourceEndpoint.getLabel()][targetEndpoint.getLabel()] = e;
    }

    public int getNumVertices(){
        return numVertices;
    }

    public LinkedList<Vertex> getAdjList(Vertex v){
        return adjLists.get(v.getLabel());
    }

    public Edge getAdjMatrixEntry( Vertex u, Vertex v){
        return adjMatrix[u.getLabel()][v.getLabel()];
    }

    public Vertex getVertexByIndex (int i){
        return vertices[i];
    }

    public LinkedList<Vertex> getAdjListByLabel(int v) {
        return adjLists.get(v);
    }

}
