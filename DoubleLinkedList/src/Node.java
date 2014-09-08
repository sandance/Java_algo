/**
 * Created by nazmul on 8/8/14.
 */
public class Node<T> {

    Node <T> next;
    Node <T> prev;
    T element;

    public Node(T element, Node next, Node prev){

        this.element = element;
        this.next = next;
        this.prev = prev;

    }
}
