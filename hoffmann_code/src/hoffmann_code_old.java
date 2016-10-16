import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 * Created by NIslam on 10/13/16.
 */
public class hoffmann_code_old {
    public static final int MAX_TREE_HT = 100;


    public void displayHeap() {

    }

    public static boolean isLeaf(Node root){
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
/*
    public static void main(String[] args ) throws Exception {

        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Enter total num of nodes ");
        int nodeSize = in.nextInt();

        int size = nodeSize * 2;
        PriorityQueue<Node> heap = new PriorityQueue<Node>();

        //Heap heap = new Heap(size);

        System.out.println("Enter elements into heap");
        int i;
        for(i=0;i<nodeSize;i++){
            int freq = in.nextInt();
            char data = in.nextLine().charAt(0);

            System.out.println("Inseting: "+freq+" and "+ data);
            Node newNode = new Node(freq, data,null, null);

            heap.add(newNode);

        }

        //System.out.println("Display Heap: ");
        //heap.displayHeap();

        // create Hoffmann Tree using minHeap
        while(!heap.isEmpty()){
            // Step 2: Extract the two minimum freq items from min Heap
            Node left = heap.remove();
            Node right = heap.remove();


            //Create a new internal node with frequency equal to the sim of the two nodes freq.
            //Add this node to min Heap with '$' special character for internal nodes

            Node top = new Node (left.getFreq()+right.getFreq(), '$', left, right);
            top.left = left;
            top.right = right;
            heap.add(top);


        }



        Node root = heap.peek();

        int [] arr = new int [MAX_TREE_HT];
        int top = 0;
        printCode(root, arr, top);


    }*/
}
