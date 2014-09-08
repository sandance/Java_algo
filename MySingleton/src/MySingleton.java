import java.util.*;
import java.lang.*;
import java.io.*;



/**
 * Created by nazmul on 8/5/14.
 */
public class MySingleton {



    private static MySingleton ourInstance = new MySingleton();

    public static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {


    }

    public void testme() {
        System.out.println("Hey....it is working");
    }

    public static void main(String[] args) throws  IOException {
        MySingleton ms = getInstance();

        ms.testme();
    }
}