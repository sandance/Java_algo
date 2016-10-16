/**
 * Created by NIslam on 9/30/16.
 */
public class PriorityQueue {
    private Heap theHeap;


    public void insert(Node node){
        theHeap.insert(node.getKey());

    }

    public Node remove(){
        return theHeap.remove();
    }

}
