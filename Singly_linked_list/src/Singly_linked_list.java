import java.io.IOException;
import java.util.*;



/**
 * Created by nazmul on 8/7/14.
 */
public class Singly_linked_list<T> {
        private Node<T> head;
        private Node<T> tail;

        public void add(T element) {
            Node<T> nd = new Node<T>();
            nd.setValue(element);
            System.out.println("Adding: " + element);

            /* check if the list is empty */

            if (head == null) {
                head = nd;
                tail = nd;

            } else {
                // set current tail next link to new node
                tail.setNextRef(nd);
                // set tail as newly created node
                tail = nd;
            }

        }


        public void addAfter(T element, T after) {
            Node<T> tmp = head;
            Node<T> refNode = null;

            System.out.println("Traversing to all nodes .....");

            /* Traversing till given element */

            while(true){
                if(tmp==null)
                    break;

                if(tmp.compareTo(after) == 0){
                    refNode = tmp;
                    break;

                }
                tmp = tmp.getNextRef();


            }
            if(refNode != null) {
                //add a element after the target node

                Node<T> nd = new Node<T>();
                nd.setValue(element);

                nd.setNextRef(tmp.getNextRef());

                if (tmp == tail) {
                    tail = nd;

                }
                tmp.setNextRef(nd);
            }
            else {
                System.out.println("Unable to find the given element...");

            }

        }



        public void deleteAfter(T after){

            Node<T> tmp = head;

            Node<T> refNode = null;
            System.out.println("Traversing all nodes...");

            while(true){
                if(tmp==null)
                    break;

                if(tmp.compareTo(after)==0){
                    // Found the target node, add after this node
                    refNode = tmp;
                    break;

                }

                tmp = tmp.getNextRef();

            }

            if(refNode !=null) {
                // take the reference from it
                tmp = refNode.getNextRef();

                // put this ones ref into next node
                refNode.setNextRef(tmp.getNextRef());

                if (refNode.getNextRef() == null) {
                    tail = refNode;
                }
                System.out.println("Deleted: " + tmp.getValue());
            }else {
                System.out.println("Unable to find the given element...");
            }



        }


        public void traverse() {

            Node<T> tmp = head;

            while(true){

                if((tmp)==null)
                    break;
                System.out.println(tmp.getValue());
                tmp = tmp.getNextRef();
            }
        }


        public static void main(String[] args) throws IOException {

            Singly_linked_list<Integer> sl = new Singly_linked_list<Integer>();
            sl.add(3);
            sl.add(32);
            sl.add(54);
            sl.add(89);
            sl.addAfter(76,54);
            sl.deleteAfter(76);

            sl.traverse();

        }









}


