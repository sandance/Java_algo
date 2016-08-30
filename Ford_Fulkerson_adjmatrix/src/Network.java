import com.sun.javafx.geom.Vec2d;

import java.util.*;

/**
 * Created by NIslam on 8/25/16.
 */
public class Network extends DirectedGraph {
    public Vertex source;
    public int sourceLabel;
    public Vertex sink;
    public int sinkLabel;

    public Network(int n) {
        super(n);

        // add the source vertex - assumed to have label 0
        sourceLabel = 0;
        source = addVertex(sourceLabel);

        // add the sink vertex -- assumed to have label numVertices
        sinkLabel = numVertices - 1;
        sink = addVertex(sinkLabel);

        // add remaining vertices
        for (int i = 1; i <= numVertices - 2; i++)
            addVertex(i);
    }

        // return the sink vertex

    public Vertex getSink() {
        return sink;
    }

    public Vertex getSource() {
        return source;
    }

    /*
     Adds the edge with specified source and target vertices and capacity
    */

    public void addEdge(Vertex source, Vertex target, int cap) {
        Edge e = new Edge(source, target, cap);
        adjLists.get(source.getLabel()).addLast(target);
        adjMatrix[source.getLabel()][target.getLabel()] = e;
        System.out.println("Edge: i="+source.getLabel()+"  j= "+target.getLabel()+" weight: "+adjMatrix[source.getLabel()][target.getLabel()].getCapacity());
    }

    /**
     * Returns true if and only if the assignment of integers to the flow fields of
     * each edge in the network is a valid flow.
     *
     * @return true, if the assignment is a valid flow
     * <p>
     * valid flow:
     * 1) total flow out from s = total flow into t
     * 2) capacity constr: for every edge, 0<=flow<=capacity
     * 3) flow conservation constr: for every vertex apart from s and t, total in flow = total out flow
     **/

    public boolean isFlow() {
            /*
            A Matrix that contains the flow of every edge or 0 if the edge does not exist
            flowMatrix[i][j] contains the flow of the edge (i,j) where i and j are labels
            of the nodes
            */

        int[][] flowMatrix = new int[numVertices][numVertices];

        int[] inflow = new int[numVertices];
        int[] outflow = new int[numVertices];

        // initialize inflow and outflow

        for (int i = 0; i < numVertices; i++) {
            inflow[i] = 0; //total incoming flow for a node with lavel i
            outflow[i] = 0; // total outgoing flow for a node with label i

        }

        //** build the flow matrix

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                Edge e = getAdjMatrixEntry(getVertexByIndex(i), getVertexByIndex(j));
                int flow = 0;

                if (e != null) {
                    flow = e.getFlow(); // update the flow if the edge exist

                    if (flow < 0 || flow > e.getCapacity())
                        return false;

                }
                flowMatrix[i][j] = flow; // if the edge does not exist , we put 0

            }

        }

        /*
         Derive the incoming and outgoing flow for each vertex
         */

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                outflow[i] += flowMatrix[j][i];
                inflow[i]  += flowMatrix[i][j];
            }
        }

            /* check the flow conversion constraint */
        for (int i = 1; i < numVertices - 1; i++) {
            if (inflow[i] != outflow[i])
                return false;
        }

            /* check the flow in the sink as the flow out of the source */
        if (inflow[sinkLabel] != outflow[sourceLabel]) {
            return false;
        }

        return true;


    }

    /**
     * Gets the value of the flow ; the total flow out from s or the total flow into t
     */
    public int getValue() {
        int totalFlow = 0;
        /** total flow of the source , same as total flow out of sink **/
        LinkedList<Vertex> neighbors = getAdjListByLabel(sourceLabel);
        for (int i = 0; i < neighbors.size(); i++) {
            totalFlow += getAdjMatrixEntry(source, neighbors.get(i)).getFlow();
        }
        return totalFlow;
    }

    /***
     * Prints the flow through the network in the following format
     * (u, v) c(u,v) / f(u , v)
     * where (u,v) is an edge
     * c(u, v) is the capacity
     * and f(u , v) is the flow though that edge
     */

    public void printFlow() {
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                Edge e = getAdjMatrixEntry(getVertexByIndex(u), getVertexByIndex(v));
                if (e != null) {
                    System.out.println("(" + u + "," + v + ") " + e.getCapacity() + "/" + e.getFlow());
                }
            }
        }
    }


    /**
     * updates the flow bt adding / substracting the new flow derived after an iteration
     *
     * @param resEdge: The edge from the residual graph that is the part of augm path
     *                 we will use this edge to the oriiginal edge in the graph that is to be updated
     */

    public void updateFlow(Edge resEdge, int newFlow) {
        Vertex residualVU = resEdge.getSourceVertex();
        Vertex residualVV = resEdge.getTargetVertex();

        Edge edge = getAdjMatrixEntry(residualVU, residualVV);

        //** we have a backward edge , have to substract the new flow **//
        if (edge == null) {
            edge = getAdjMatrixEntry(residualVV, residualVU);
            edge.setFlow(edge.getFlow() - newFlow);
        }
            /* we have a forward edge and have to add new flow */
        else {
            edge.setFlow(edge.getFlow() + newFlow);
        }


    }


}

