import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.io.*;




/**
 * Created by nazmul on 8/6/14.
 */

/**
 *  Here T is a type parameter, and it will be replaced with actual type
 *  when the object got created
 */

class SimpleGeneric<T> {

    // declaration of object type T
    private T objReff = null;

    // constructor to accept type parameter T

    public SimpleGeneric(T param){
        this.objReff = param;

    }

    public T getObjReff() {
        return this.objReff;
    }

    // this method prints the holding parameter type

    public void printType() {
        System.out.println("Type: "+ objReff.getClass().getName());
    }

}


public class GenericExample {

        public static void main(String[] args) throws IOException {

                SimpleGeneric<String> sgs = new SimpleGeneric<String>("Java2Novice");
                sgs.printType();

                // next try for boolean

                SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(Boolean.TRUE);
                sgb.printType();

        }


}
