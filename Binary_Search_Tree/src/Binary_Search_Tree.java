import sun.org.mozilla.javascript.ast.ParenthesizedExpression;

import java.lang.reflect.ParameterizedType;
import java.util.*;


/**
 * Created by nazmul on 12/23/14.
 */
public class Binary_Search_Tree {
    private Node root;

    /**
     * Constructor
     */
    public Binary_Search_Tree() {
        root = null;
    }

    /**
     * Find a key from the Binary Search Tree
     * @param key
     * @return Node that contains that key
     */
    public Node find(int key){ // find node with given key, and start from the root
        Node current = root;
        while(current.idata != key) {
            if ( key < current.idata){
                current = current.leftChild;
            }else
                current = current.rightChild;

            if (current == null)
                return null;
        }
        return current;
    } // End of Find


    public void insert(int id, double dd){
        Node newNode = new Node();
        newNode.idata = id;
        newNode.dData = dd;

        // if this is the first node
        if(root ==null){
            root = newNode;
        }else { // If there are already nodes present

            Node current = root;
            Node parent;

            // Look through all node
            while(true){
                parent = current;

                if( id < current.idata){
                    current = current.leftChild;

                    if( current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;

                    if(current ==null){
                        parent.rightChild = newNode;
                        return;
                    }
                } // end of else

            } // end of while

        } // end of not root

    } // end of insertion

    /**
     * InOrder Traversal ( check the nodes left subtree, and then visit the node and finally traverse the right subtree )
     * @param localroot
     */
    public void InOrder(Node localroot){
        if(localroot != null){
            InOrder(localroot.leftChild);
            System.out.println(localroot.idata + " ");
            InOrder(localroot.rightChild);
        }
    } // end of Inorder traversal


    public  void preOrder(Node localroot){
        if ( localroot != null){
            System.out.println(localroot.idata + " ");
            preOrder(localroot.leftChild);
            preOrder(localroot.rightChild);
        }
    }


    private void postOrder(Node localroot){
        if (localroot !=null){
            postOrder(localroot.leftChild);
            postOrder(localroot.rightChild);
            System.out.println(localroot.idata + " ");
        }
    }


    public Node minimum(){
        Node current = root;
        Node parent = root;

        while(current != null){
            parent = current;
            current = current.leftChild;
        }
        return parent;
    } // returns the minimum element from binary search tree


    public Node maximum(){
        Node current = root;
        Node parent = root;

        while(current != null){
            parent = current;
            current = current.rightChild;
        }
        return parent;
    } // returns the maximum element from binary search tree

    /**
     * Deletion from a Binary search tree has 3 cases to consider
     * 1. If the node dont have any child
     * 2. If the node have one child
     * 3. If the node to be deleted has two children
     *
     */


    /* Java code to find inorder successor */

    private Node getSuccessor (Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;

        Node current = delNode.rightChild;

        while (current != null ){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if ( successor != delNode.rightChild) {
            // if successor is not right child
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;

    } // end of getSuccessor


    public boolean delete(int key) {

        /** Case 1:
         * Java code to delete a Node with No Children
         */

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.idata != key) {  // Search for the key
            parent = current;

            if (key < current.idata) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) { // end of the list
                return false;

            }

            // Found the node to delete
            // Now we need to verify that it has no children and if it is yes, just delete it

            if (current.leftChild == null && current.rightChild == null) {
                if (current == root) { // if it is root
                    root = null;
                } else if (isLeftChild) {
                    parent.leftChild = null;
                } else
                    parent.rightChild = null;


            }

            /** Case 2:
             * Now If the node needs to be deleted has one child
             *
             * The Child of the node to be deleted may b either a left or right child
             */


            if (current.rightChild == null) {
                // If no right child, replace with left subtree
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) // left child of parent
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;
            } else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else
                    parent.rightChild = current.rightChild;
            } else {
                /**
                 * Case 3: When the node to be deleted has two child
                 *
                 * We have to replace the node , with its inorder successor
                 *
                 * Inorder successor is = "Smallest of the set of nodes that are larger than the original node"
                 *
                 */
                // Get successor of node to delete
                Node successor = getSuccessor(current);

                // connect parent of successor instead
                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.leftChild = successor;
                else
                    parent.rightChild = successor;


                // connect successor to currents left child

                successor.leftChild = current.leftChild;

            } // end of else


        }

        return true;
    }

}
