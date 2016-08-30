import sun.awt.image.ImageWatched;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by NIslam on 8/25/16.
 */
public class Ford_Fulkerson {

    public static LinkedList<Edge> bfs (DirectedGraph graph, Object start , Object target, HashMap<Edge, Integer> flow){
        HashMap<Object, Edge> parent = new HashMap<Object,Edge>();

        LinkedList<Object> fringe = new LinkedList<Object>();

        parent.put(start, null);
        fringe.add(start);

        while(!fringe.isEmpty()){

            LinkedList<Object> newFringe = new LinkedList<Object>();

            for(Object nodeID : fringe){
                Node node = graph.getNode(nodeID);


                // iterate through all the other edges
                for(int i=0; i< node.getOutLeadingOrder(); i++){
                    Edge e = node.getEdge(i);
                    // only add the node if the flow can be changed in an out
                    // leading direction . Break when target is reached

                    if (e.getStart().equals(nodeID) && !parent.containsKey(e.getTarget())
                            && flow.get(e) < e.getCapacity()) {
                        parent.put(e.getTarget(), e);
                        if (e.getTarget().equals(target))
                            break;
                        newFringe.add(e.getTarget());
                    }
                    else if (e.getTarget().equals(nodeID) && !parent.containsKey(e.getStart() ) && flow.get(e) > 0) {
                        parent.put(e.getStart(), e);

                        if (e.getStart().equals(target))
                            break;

                        newFringe.add(e.getStart());
                    }
                }
            }
            fringe = newFringe;
        }


        // return null, if no path was found
        if (fringe.isEmpty())
            return null;

        Object node = target;
        LinkedList<Edge> path = new LinkedList<Edge>();

        // back traverse
        while(!node.equals(start)){
            Edge e = parent.get(node);

            path.addFirst(e);

            if ( e.getStart().equals(node))
                node = e.getTarget();
            else
                node = e.getStart();
        }

        return  path;

    }

    public static int getFlowSize(HashMap<Edge, Integer> flow, DirectedGraph graph, Object source){
        int maximumFlow = 0;

        Node sourceNode = graph.getNode(source);
        for(int i=0; i < sourceNode.getOutLeadingOrder(); i++){
            maximumFlow += flow.get(sourceNode.getEdge(i));
        }

        return maximumFlow;
    }




    public static HashMap<Edge, Integer> getMaxFlow (DirectedGraph graph, Object source, Object sink) {
        // The path from source to sink that is found on each iteration
        LinkedList<Edge> path;

        // The flow; the capacity of each edge that is actually used
        HashMap<Edge, Integer> flow = new HashMap<Edge, Integer>();

        // Create intially empty flow
        for (Edge e : graph.getEdges()){
            flow.put(e, 0);
        }

        // Algorithm
        while((path = bfs(graph, source, sink, flow)) != null){
            // Find out the flow that can be send on the found path
            int minCapacity = Integer.MAX_VALUE;
            Object lastNode = source;
            int capacity;

            for(Edge edge : path){

                // traverse to the start vertex and find min capacity flow of entire path
                if (edge.getStart().equals(lastNode)){
                    capacity = edge.getCapacity() - flow.get(edge);
                    lastNode = edge.getTarget();
                } else {
                    capacity = flow.get(edge);
                    lastNode = edge.getStart();
                }
                minCapacity = Math.min(capacity, minCapacity);
            }


            // change flow of all edges of the path by the value calculated above
            lastNode = source;


            for (Edge edge : path){

                if (edge.getStart().equals(lastNode)) {
                    flow.put(edge, flow.get(edge) + minCapacity);
                    lastNode = edge.getTarget();
                }
                else {
                    flow.put(edge , flow.get(edge) - minCapacity);
                    lastNode = edge.getStart();
                }
            }
        }
        return flow;
    }

    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner();
        System.out.println("Enter Source and Sink vertex");
        int source = sc.nextInt();
        int sink = sc.nextInt();

        DirectedGraph graph = new DirectedGraph();
        System.out.println("Enter no of vertices and edges");

        int V = sc.nextInt();
        int E = sc.nextInt();

        for(int i=0;i<E;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);
        }

        HashMap<Edge, Integer> flow = getMaxFlow (graph, source, sink);
        System.out.println(getFlowSize(flow,graph,source));


    }
}
