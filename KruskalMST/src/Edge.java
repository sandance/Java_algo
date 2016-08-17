/**
 * Created by NIslam on 8/17/16.
 */
public class Edge implements Comparable<Edge>{

    public int src;
    public int dest;
    public int weight;

    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }

}
