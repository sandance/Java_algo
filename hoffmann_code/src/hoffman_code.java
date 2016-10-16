
import java.io.*;
import java.util.*;

/**
 * Created by NIslam on 10/15/16.
 */
public class hoffman_code {

    public static final int MAX_TREE_HT = 100;


    public static void displayHeap(PriorityQueue<Node> heap){
        System.out.println("Heap elements");
        while(!heap.isEmpty()){
            System.out.println("Frequency: "+ heap.poll().getFreq());
        }

    }

    public static boolean isLeaf(Node root)
    {
        return root.left == null && root.right == null;
    }


    public static void printArr(int [] arr, int n){
        for(int i=0; i < n; ++i){
            System.out.print(arr[i]);
        }
        System.out.println();
    }



    public static void printCode(Node root, int [] arr, int top) {
        // assign 0 to the left edge and recur
        if ( root.left != null){
            arr[top] = 0;
            printCode(root.left, arr, top + 1);
        }

        // assign 1 to the right edge and recur
        if ( root.right != null){
            arr[top] = 1;
            printCode(root.right, arr, top + 1);
        }

        // if this is leaf node, then it contains one of the input
        // characters, print the character and its code from arr[]
        if (isLeaf(root)){
            System.out.println(root.getData());
            printArr(arr, top);
        }
    }


    public static void main(String[] args) {

        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter total number of nodes");
        int size = in.nextInt();

        for (int i = 0; i < size; i++){
            int freq = in.nextInt();
            char data = in.next().charAt(0);

            Node newNode = new Node(freq, data, null, null);
            heap.add(newNode);
        }

        while(heap.size() >= 2){
            //Node old = heap.remove();
            Node left = heap.poll();
            Node right = heap.poll();

            int topFreq = left.getFreq() + right.getFreq();
            System.out.println("Top Frequency"+topFreq);
            char topData = '$';

            Node top = new Node (topFreq, topData , left, right);
            //top.left = left;
            //top.right = right;

            heap.add(top);

        }

        // the remaining one node is the root node of the Tree
        Node root = heap.poll();

        int [] arr = new int[MAX_TREE_HT];
        int top = 0;

        printCode(root, arr, top);

        //displayHeap(heap);


    }
}
