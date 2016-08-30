import java.util.ArrayList;

/**
 * Created by NIslam on 8/24/16.
 */
public class Node {

    private ArrayList<Edge> edges = new ArrayList<Edge>();


    void addEdge(Edge edge){
        this.edges.add(edge);
    }

    Edge getEdge(int number){
        if (this.edges.size() <= number){
            return null;
        }else {
            return this.edges.get(number);
        }
    }

    int getOutLeadingOrder() {
        return this.edges.size();
    }
}
