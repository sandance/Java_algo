import java.lang.*;
import java.util.*;


/**
 * Created by NIslam on 8/24/16.
 */
public class Edge {

    private final Object start;
    private final Object target;
    private final int capacity;

    Edge(Object start, Object target , int capacity){
        this.capacity = capacity;
        this.start = start;
        this.target = target;
    }

    Object getTarget() {
        return target;
    }

    Object getStart() {
        return start;
    }

    int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return this.start +"\t ->" + this.target +"\t ->"+this.capacity;
    }

}
