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
    /*
    public boolean isEmpty(){
        return currentSize==0;
    }*/

    /*
    public boolean insert(int key){
        if(currentSize == maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        // Insertion so, you need to tickleup
        tickleup(currentSize++);
        return true;

    }*/

    public void tickleup(int index){
        int parent = (index - 1) /2;

        Node bottom = heapArray[index];

        while(index >0 && heapArray[parent].getKey() < bottom.getKey()){
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

            if ( rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey() ){
                largerChild = rightChild;

            }
            else
                largerChild = leftChild;

            if (top.getKey() >= heapArray[largerChild].getKey()){
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        }
        heapArray[index] = top; // root to index
    }


    public void displayHeap(){
        System.out.println("HeapArray : ");
        System.out.println("*************");

        for(int i=0;i<maxSize;i++){
                System.out.println(heapArray[i].getKey() + " ");
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

    public void incrementSize(){
        currentSize++;
    }






    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter size of the Heap");
        int size = in.nextInt();

        Heap heap = new Heap(size);
        boolean success;

        System.out.println("Enter elements into heap");
        for(int i=0;i<size;i++){
            int key = in.nextInt();
            Node newNode = new Node(key);

            heap.insertAt(i,newNode);
            heap.incrementSize();

        }


        System.out.println("Display Heap: ");
        heap.displayHeap();

        // make random array into heap

        for( int j=size/2 -1 ; j >= 0; j--)
            heap.tickledown(j);

        System.out.println("Display Heap Again: ");
        heap.displayHeap();


        for(int i=size - 1; i >= 0 ; i--){
            // remove from heap and store at array end
            Node biggestNode = heap.remove();
            heap.insertAt(i,biggestNode);
        }

        System.out.println("Sorted: ");
        heap.displayHeap();
    }

}