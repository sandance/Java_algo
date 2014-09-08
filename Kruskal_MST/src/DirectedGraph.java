import java.util.*;
import java.lang.*;


public final class DirectedGraph<T> implements Iterable<T> {

    private final Map<T,Map<T,Double>> mGraph = new HashMap<T, Map<T, Double>>();

    public boolean addNode(T node){

        /* If the node already exist , dont do anything */

        if(mGraph.containsKey(node))
            return false;

        // otherwise add the node with an empty set of  outgoing edges */

        mGraph.put(node,new HashMap<T, Double>());
        return true;
    }


    public void addEdge (T one, T two, double length) {

        /* confirm both endpoints exist */
        if (!mGraph.containsKey(one) || !mGraph.containsKey(two)) {
            throw new NoSuchElementException("Both Nodes must be in the Graph");
        }

        /* Add the Edge in both direction */

        mGraph.get(one).put(two, length);
        mGraph.get(two).put(one, length);
    }



    /* Removes the edge between the indicated endpoints from the Graph */

    public void removeEdge(T one, T two){
        /* confirm both endpoints exist */
        if(!mGraph.containsKey(one) | !mGraph.containsKey(two))
            throw new NoSuchElementException("Both node must be in the Graph");

        /*Remove the edges from both adjacency list */

        mGraph.get(one).remove(two);
        mGraph.get(two).remove(one);

    }

    /* Given two endpoints , returns the cost of the edge between them */

    public double edgeCost(T one, T two){

        /* confirm both endpoints exist */

        if(!mGraph.containsKey(one) || !mGraph.containsKey(two))
            throw new NoSuchElementException("Both nodes must be in the Graph");

        /* look up the edge between the two */

        Double result = mGraph.get(one).get(two);

        /* If there is no edge there, report an error */

        if(result == null)
            throw new NoSuchElementException("Edge does not exist in the graph");


        /* otherwise return the cost */
        return result;


    }

    /** Given a node, return all the edges leaving that node
     * @param   node whose edges should be queried
     * @return An immutable view of the edges leaving that node
     * @throws  NoSuchElementException if the node does not exist
     *
     */

    public Map<T, Double> edgesFrom (T node){
        /* Check that the node exists */
        Map<T,Double > arcs = mGraph.get(node);

        if(arcs == null)
            throw new NoSuchElementException("Souce code does not exist");

        return Collections.unmodifiableMap(arcs);
    }



    /* Return whether a node is contained in the Graph */

    public boolean containsNode(T node) {
        return mGraph.containsKey(node);
    }

    /* Return an iterator that can traverse the nodes in the Graph */

    public Iterator<T> iterator () {
        return mGraph.keySet().iterator();
    }

    /* Reeturns the number of nodes in the Graph */

    public int size() {
        return mGraph.size();
    }

    public boolean isEmpty() {
        return mGraph.isEmpty();
    }

}