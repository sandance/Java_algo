import java.io.IOException;
import java.util.*;


/**
 * Created by NIslam on 8/25/16.
 */
public class residualGraph extends Network {
    public Edge [][] residualAdjMatrix;

    public ArrayList<LinkedList<Vertex>> residualAdjLists;

    /**
     *
     */
    public residualGraph (Network net) throws IOException {
        super(net.getNumVertices());

        // initialize residualMatrix

        residualAdjMatrix = new Edge[numVertices][numVertices];
        residualAdjLists = new ArrayList<>();

        for(int u=0; u < numVertices; u++){
            residualAdjLists.add(new LinkedList<>());
            for(int v=0; v < numVertices; v++){
                residualAdjMatrix[u][v] = null;
            }
        }

        for(int u=0; u < numVertices; u++){
            LinkedList<Vertex> neighbors = net.getAdjList(getVertexByIndex(u));
            for( int v =0; v < neighbors.size(); v++){
                Vertex currN = neighbors.get(v);
                if (u != currN.getLabel()){
                    Edge edge = net.getAdjMatrixEntry(getVertexByIndex(u), currN);
                    setResidualEdges(edge);
                }
            }
        }



    }


    /**
     * Given an Edge param e in the network, set the corresponding new edges
     */
    public void setResidualEdges(Edge e){
        Vertex u = e.getSourceVertex();
        Vertex v = e.getTargetVertex();

        // 1 residual edge which is a backward edge

        if ( e.getFlow() == e.getCapacity()) { // flow is saturating
            Edge recBackEdge = new Edge(v, u, e.getFlow());

            residualAdjMatrix[v.getLabel()][u.getLabel()] = recBackEdge; // set the adj Matrix
            residualAdjLists.get(v.getLabel()).addLast(u); // add ti adj list
        }
        // residual graph has forward edge with flow = cap - flow
        // residual graph has backward edge with flow = flow
        else if ( e.getFlow() < e.getCapacity() && e.getFlow() > 0){
            int newFlow = e.getCapacity() - e.getFlow();
            Edge resForwEdge = new Edge(u,v , newFlow); // the forward edge
            Edge resBackEdge = new Edge (v, u, e.getFlow());
            residualAdjMatrix[v.getLabel()][u.getLabel()] = resBackEdge;
            residualAdjMatrix[u.getLabel()][v.getLabel()] = resForwEdge;

            residualAdjLists.get(v.getLabel()).addLast(u);
            residualAdjLists.get(u.getLabel()).addLast(v);


        }

        // 1 residual edge which is a forward edge
        else if (e.getFlow() == 0){
            int newFlow = e.getCapacity();
            Edge resForwEdge = new Edge (v,u, newFlow);
            residualAdjMatrix[u.getLabel()][v.getLabel()] = resForwEdge;
            residualAdjLists.get(u.getLabel()).addLast(v);
        }

    }

    /**
    * Find an augmenting path if one exists.
    * Determines whether there is a directed path from the source to the sink in the residual
    * graph -- if so, return a linked list containing the edges in the augmenting path in the
    * form (s,v_1), (v_1,v_2), ..., (v_{k-1},v_k), (v_k,t); if not, return an empty linked list.
    * @return the linked list
    */

    public LinkedList<Edge> findAugmentingPath() {
        int [] pred = bfs();

        // start from the sink and backtrack untul finding the source
        LinkedList<Vertex> verticesPath = new LinkedList<>();
        int currLabel = sinkLabel;
        // this means we did notmanage to reach the sink, i.e there is no augm verticesPath
        if (pred[currLabel] == -1){
            return null;

        }

        while (currLabel != sourceLabel){
            verticesPath.addFirst(getVertexByIndex(currLabel)); // add current vertex in begging of verticespath
            currLabel = pred[currLabel]; // update the current label
        }

        verticesPath.addFirst(source);

        LinkedList<Edge> augmPath = new LinkedList<>();
        for( int u=0, v=1; u < verticesPath.size() - 1 && v < verticesPath.size() ; u++, v++){
            Vertex vu = verticesPath.get(u);
            Vertex vv = verticesPath.get(v);
            augmPath.add(residualAdjMatrix[vu.getLabel()][vv.getLabel()]);
        }
        return augmPath;
    }

     /** bfs modified to return an array of size numVertices,
     * where the i-th entry of the array has the label of
     * the predecessor node of the node labeled as i after breadth first search */

    public int [] bfs () {
        LinkedList<Vertex> q = new LinkedList<>();
        int [] parent = new int [numVertices]; // parent of each node during bfs
        Arrays.fill(parent,-1);
        q.addLast(source);

        while (!q.isEmpty()){
            Vertex currV = q.removeFirst();
            LinkedList<Vertex> neighbors = residualAdjLists.get(currV.getLabel());
            for(int j=0; j< neighbors.size(); j++){
                Vertex v = neighbors.get(j);
                if ( parent[v.getLabel()] == -1){ // Vertex not visited yet
                    parent[v.getLabel()] = currV.getLabel();
                    q.addLast(v);
                }
            }
        }
        return parent;
    }


    /**
     * Print the edges and their capacitie in the residual graph
     */

    public void printResG() {
        for(int u=0; u < numVertices; u++){
            LinkedList<Vertex> neighbors = getResAdjList(getVertexByIndex(u));
            for(int v=0; v <neighbors.size(); v++){
                Vertex currN = neighbors.get(v);
                if ( u != currN.getLabel()){
                    Edge edge = getAdjMatrixEntry(getVertexByIndex(u), currN);
                    System.out.println("(u,v): (" + u + "," + currN.getLabel() + ") edge cap: " + edge.getCapacity() + " flow: " + edge.getFlow());

                }
            }
        }
    }

    /**
     * Gets the adjacency list for a given vertex vv.
     *
     * @param vv the given vertex
     * @return the adjacency list
     */
    public LinkedList<Vertex> getResAdjList(Vertex vv) {
        return residualAdjLists.get(vv.getLabel());
    }

    /**
     * Gets the adjacency list for a given vertex with label v.
     * @param v the vertex label
     * @return the adjacency list
     */
    public LinkedList<Vertex> getResAdjListByLabel(int v) {
        return residualAdjLists.get(v);
    }

    /**
     * Gets the adjacency matrix entry corresponding to vertices uu and vv.
     *
     * @param uu the first vertex
     * @param vv the second vertex
     * @return the adjacency matrix entry
     */
    public Edge getResAdjMatrixEntry(Vertex uu, Vertex vv) {
        return residualAdjMatrix[uu.getLabel()][vv.getLabel()];
    }



}
