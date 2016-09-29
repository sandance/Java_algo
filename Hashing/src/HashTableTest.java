/**
 * Created by NIslam on 9/22/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HashTableTest {

    public static HashTable<Integer, String> hashTable;
    public static int hashSize;

    public static void main(String[] args) {

        hashTable = new SeparateChaining<Integer, String>();
        // HashTable size
        hashSize = hashTable.tableLength();

        System.out.println("Inserting 10 entries");
        for (int i = 0; i < 20; i++) {	hashTable.put((Integer)i, i+"");	}

        System.out.println("Search for a key");
        Iterable<Integer> iterator = hashTable.keys();

        for ( Integer x : iterator)
            System.out.println(hashTable.get(x));

        System.out.println("Total number of entries");
        System.out.println(hashTable.size());

        System.out.println("Delete entry from hashTable");
        hashTable.delete(10);

        System.out.println("HashTable after deletion");
        for ( Integer x : iterator)
            System.out.println(hashTable.get(x));

        System.out.println("Searching for a key");
        System.out.println(hashTable.contains(11));




    }
}
