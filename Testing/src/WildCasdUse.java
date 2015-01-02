import java.io.*;
import java.util.*;

/**
 * Created by nazmul on 12/14/14.
 */
public class WildCasdUse {
    static void printList(List<?> list){
        for(Object l:list)
            System.out.println("[" + l +"]");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(100);

        printList(list);
    }

}
