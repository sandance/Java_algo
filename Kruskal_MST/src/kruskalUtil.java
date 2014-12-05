import java.util.*;


/**
 * Kruskal algorithms works by sorting all of the graphs edges in ascending order of size,
 *
 *
 *
 *
 * Created by nazmul on 8/6/14.
 */
public class kruskalUtil {


    public static <T> DirectedGraph<T> mst (DirectedGraph<T> graph){

        DirectedGraph<T>  result = new DirectedGraph<T>();

        /* If the input graph has zero or one nodes , we're done */

        if(graph.size() <= 1)
            return result;


        /* Begin by building up a collection of all edges of the Graph */

        List<Edge<T>> edges = getEdges(graph);

        /* Sort the edges in ascending order of size */

        Collections.sort(edges);

        /* Set up the partition of nodes in a Union Find structure */

        UnionFind<T> unionFind = new UnionFind<T> ();

        for(T node : graph)
            unionFind.add(node);


        /* Add each node to the resulting graph */

        for(T node: graph)
            result.addNode(node);


        /**
         * Now, sweep over the edges, adding each edge if its endpoints arent in the same partition
         *
         *
         */
        int numEdges =0 ;

        for(Edge<T> edge : edges) {
            /* If the endpoints are connected, skip this edge */

            if(unionFind.find(edge.start) == unionFind.find(edge.end))
                continue;

            /*Otherwise, add the edge */

            result.addEdge(edge.start,edge.end,edge.cost);

            /* Link the endpoints together */

            unionFind.union(edge.start,edge.end);


            /* If we have added enough edges already, we can quit */

            if (++numEdges == graph.size())
                break;


        }


        /* Hand back the generated Graph */

        return result;


    }


    /**
     * Edge Class
     *
     * @param <T>
     */
    private static final class Edge<T> implements Comparable<Edge<T>> {

        public final T start,end;
        public final double cost;

        public final int tiebreaker;
        public static int nextTiebreaker =0;

        public Edge (T start, T end , double cost){

            this.start = start;
            this.end = end;
            this.cost = cost;

            /*Use the next Tiebreaker here */
            tiebreaker = nextTiebreaker++;

        }

        public int compareTo(Edge<T> other) {
            /* Check how the costs compare */
            if (cost < other.cost) return -1;
            if (cost > other.cost) return +1;


        /* if they have equal cost use the tiebreaker */

            return tiebreaker - other.tiebreaker;
        }
    }

    private static <T> List<Edge<T>> getEdges (DirectedGraph<T> graph) {
        Set<T> used = new HashSet<T>();

        List<Edge<T>> result = new ArrayList<Edge<T>>();

        /* scan over each node adding edges */

        for(T node: graph) {
            /* consider all outgoing edges , but be sure to check them before adding anything */

            for(Map.Entry<T, Double> entry : graph.edgesFrom(node).entrySet()){
                /* If we have seen this endpoint , it means that the edge was added in opposite direction
                when we considered that endpoint
                 */

                if ( used.contains(entry.getKey()))
                    continue;

                /* otherwise */

                result.add(new Edge<T>(node, entry.getKey(),entry.getValue()));
            }

            /* mark this node as visited */
            used.add(node);
            
        }

        return  result;
    }



}
