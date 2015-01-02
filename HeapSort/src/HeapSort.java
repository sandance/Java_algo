import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nazmul on 12/7/14.
 */
public class HeapSort {

    private Node [] heapArray;
    private int maxSize;
    private  int currentSize;

    public HeapSort(int size){
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEMpty() {
        return currentSize == 0;
    }

/*
    public void displayHeap(){
        System.out.println("Heap Table");
        while(heapArray[])
    }
*/
    public Node remove(){
        // delete the max element

        Node root = heapArray[0];

        // replace root with last element of heap
        heapArray[0] = heapArray[--currentSize];
        tickledown(0);
        return root;
    }

    public void tickledown(int index){


        int largestChild;
        Node root = heapArray[index];

        while(index < currentSize /2){

            int leftChild = 2*index +1;
            int rightChild = 2*index +2;

            if(rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey())
                largestChild = rightChild;
            else
                largestChild = leftChild;

            if( root.getKey() >= heapArray[largestChild].getKey() )
                break;

            heapArray[index] = heapArray[largestChild];
            //heapArray[largestChild] = root;
            index = largestChild; // go down

        } // when all done
        heapArray [index] = root;
    }

    public void insertAt(int index, Node newNode){
        heapArray[index] = newNode;

    }

    public void insert(int key){
        if (currentSize == maxSize)
            System.out.println("Heap is full");
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        tickleup(currentSize++);
    }

    public void tickleup(int index){
        int parent = (index -1) /2;

        Node bottom = heapArray[parent];
        while(index >0 && heapArray[parent].getKey() < bottom.getKey()){
            // go up and replace
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent -1) /2;

        }
        heapArray[index] = bottom;
    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        System.out.println("Enter number of elements into heap");
        int n = in.nextInt();


        HeapSort heapSort = new HeapSort(n);


        System.out.println("Enter elements to heap");
        for(int i=0; i < n;i++){
            int akey = in.nextInt();
            heapSort.insert(akey);
        }

        System.out.print("Heap Sort");
        for(int i=0;i<n;i++)
            System.out.print(heapSort.remove().getKey()+" ");


    }
}
