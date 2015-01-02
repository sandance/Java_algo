import java.io.*;
import java.util.*;

public class AscendingHeap {

    private Node [] headArray;
    private int currentSize ;
    private int arraySize ;

    public AscendingHeap(int maxSize){
        arraySize = maxSize;
        currentSize = 0;
        headArray = new Node[arraySize];
    }

    public void insert(int key){
        if (arraySize == currentSize)
            System.out.println("Heap is full");

        Node newNode = new Node(key);
        headArray[currentSize] = newNode;
        tickleup(currentSize++);
    }

    public void tickleup(int index){
        int parent = (index -1)/2;

        Node bottom = headArray[index];

        while(index >0 && headArray[parent].getKey() < bottom.getKey()){
            headArray[index] = headArray[parent];
            index = parent;
            parent = (parent -1) /2;

        }
        headArray[index] = bottom;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }


    public Node remove(){
        Node top = headArray[0];
        headArray[0]=headArray[--currentSize];
        tickledown(0);
        return top;
    }

    public void tickledown(int index){
        int largestChild;
        Node root = headArray[index];

        while(index < currentSize/2){
            int leftChild = 2*index +1;
            int rightChild = 2*index +2;

            if ( rightChild < currentSize/2 && headArray[rightChild].getKey()  > headArray[leftChild].getKey()){
                largestChild = rightChild;


            }else
                largestChild = leftChild;

            if( root.getKey() > headArray[largestChild].getKey() )
                break;

            headArray[index] = headArray[largestChild];
            index = largestChild;
        }
        headArray[index] = root;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

    }

}