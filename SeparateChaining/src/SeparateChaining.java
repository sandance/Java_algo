import java.io.*;
import java.util.*;

public class SeparateChaining {

    private Link first; // Reference to first list item

    public void SeparateChaining(){
        first = null;
    }

    public void displayList(){

        Link current = first;
        System.out.println("List (first--> last");

        while(current != null){
            current.displayLink();
            current = current.next;

        }
        System.out.println("");
    }


    public void insert(Link theLink){
        int key = theLink.getKey();

        Link previous = null;
        Link current  = first;

        while( current != null && key > current.getKey()){
            previous = current;
            current = current.next;
        }
        if (previous == null ) { // if beginning of list
            first = theLink;
        }
        else {  // if not at the beginning
            previous.next = theLink;
            theLink.next = current;
        } // end insert





    }

    public void delete (int key){
        Link previous = null;
        Link current = first;

        while ( current != null && key != current.getKey()){
            previous = current;
            current = current.next;
        }

        if (previous == null){
            first = first.next;
        }
        else {
            previous.next = current.next;
        }
    }



    public Link find (int key){
        Link current = first;

        while(current != null && current.getKey() <= key){
            if(current.getKey() == key)
                return current;
            current = current.next;



        }
        return null;
    }


}