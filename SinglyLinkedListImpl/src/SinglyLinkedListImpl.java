import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.*;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.lang.System;
import java.util.*;


abstract class Node<T> implements Comparable<T> {

    private T value;
    private Node<T> nextRef;


    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<T> ref){
        this.nextRef = ref;
    }

    //@override
    public int compareTo(T arg){
        if(arg == this.value){
            return 0;
        }else
            return 1;
    }

}


public class SinglyLinkedListImpl {

    private Node<T> head;
    private Node<T> tail;






}