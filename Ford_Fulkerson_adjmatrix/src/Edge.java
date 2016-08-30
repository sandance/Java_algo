/**
 * Created by NIslam on 8/25/16.
 */
public class Edge {
    private Vertex sourceEndpoint;
    private Vertex targetEndpoint;
    private int flow;
    private int capacity;

    public Edge (Vertex u, Vertex v){
        sourceEndpoint = u;
        targetEndpoint = v;
    }

    public Edge(Vertex u, Vertex v, int c){
        sourceEndpoint = u;
        targetEndpoint = v;
        flow =0;
        capacity = c;
    }

    // return the source vertex
    public Vertex getSourceVertex() {
        return sourceEndpoint;
    }

    public Vertex getTargetVertex() {
        return targetEndpoint;
    }

    public void setFlow(int f){
        flow = f;
    }

    public int getFlow() {
        return flow;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int c) {
        capacity = c;
    }


}
