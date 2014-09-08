/**
 * Created by nazmul on 8/8/14.
 */
public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public DoubleLinkedList() {
        size =0;
    }

    public int size(){
         return size;
     }

    public boolean isEmpty() {
        return size==0;
    }




}
