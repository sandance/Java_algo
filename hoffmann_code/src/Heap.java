import java.io.*;
import java.util.*;

public class Heap {

    private Node [] heapArray;
    private  int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return currentSize==0;
    }


    public boolean insert(int key, char data, Node left, Node right){
        if(currentSize == maxSize)
            return false;
        Node newNode = new Node(key,data, left, right);
        heapArray[currentSize] = newNode;
        // Insertion so, you need to tickleup
        tickleup(currentSize++);
        return true;

    }

    public void tickleup(int index){
        int parent = (index - 1) /2;

        Node bottom = heapArray[index];

        while(index >0 && heapArray[parent].getFreq() < bottom.getFreq()){
            heapArray[index] = heapArray[parent]; // move node down
            index = parent;
            parent = (parent -1) /2;            // parent to its parent
        }
        heapArray[index] = bottom;

    } // end trickleUp

    /**
     * Delete item with the max key, and its on the top
     * @return the maximum element from top of the heap
     */

    public Node remove(){
        Node top = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        tickledown(0);
        return top;

    }

    public void tickledown(int index){
        int largerChild;
        Node top = heapArray[index];

        // While top node has at least one child
        while( index < currentSize /2) {
            int leftChild = 2* index +1;
            int rightChild = 2* index +2;

            if ( rightChild < currentSize && heapArray[rightChild].getFreq() > heapArray[leftChild].getFreq() ){
                largerChild = rightChild;

            }
            else
                largerChild = leftChild;

            if (top.getFreq() >= heapArray[largerChild].getFreq()){
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        }
        heapArray[index] = top; // root to index
    }

    public boolean change (int index, int newValue){
        if ( index <  0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getFreq();
        heapArray[index].setFreq(newValue);

        if (oldValue < newValue) {
            // if raised
            tickleup(index); // trickle it up
        }else{
            tickledown(index); // trickle it down
        }
        return true;

    }


    public void displayHeap(){
        System.out.println("HeapArray : ");
        System.out.println("*************");

        for(int i=0;i<maxSize;i++){
                System.out.println(heapArray[i].getFreq() + " ");
            System.out.println();

        }
    }


    /**
     * insertion
     * @param args
     * @throws IOException
     */

    public void insertAt(int index, Node newNode){
        heapArray[index] = newNode;
    }

    public void incrementSize()
    {
        currentSize++;
    }
    /*
    public boolean isEmpty(){
        return currentSize == 0;
    }*/

}