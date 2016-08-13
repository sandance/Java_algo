/**
 * Created by NIslam on 8/11/16.
 */

public class Heap {

    private Edge [] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize =0;
        heapArray = new Edge[maxSize];
    }


    public boolean isEmpty() {
        return currentSize==0;
    }

    public boolean insert (int key){
        if (currentSize==maxSize)
            return false;
        Edge newEdge = new Edge(key);
        heapArray[currentSize] = newEdge;
        // insertion so, you need to tickleup
        tickleUp(currentSize++);
        return true;
    }

    public Edge remove(){
        Edge top = heapArray[0];

        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return top;

    }

    public void tickleUp(int index){
        int parent = (index -1) /2;

        Edge bottom = heapArray[index];
        while (index >0 && heapArray[parent].getKey() < heapArray[index].getKey()){
            heapArray[index] = heapArray[parent];
            index = parent ;
            parent = (parent -1) /2;
        }
        heapArray[index] = bottom;

    }

    public void trickleDown(int index){
        int largerChild;

        Edge top = heapArray[index];

        while(index < currentSize /2){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey()){
                largerChild = rightChild;
            }else
                largerChild = leftChild;

            if (top.getKey() >= heapArray[largerChild].getKey() ){
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }

    public void insertAt(int index , Edge newEdge) {
        heapArray[index] = newEdge;
    }

    public void incrementSize(){
        currentSize++;
    }

}
