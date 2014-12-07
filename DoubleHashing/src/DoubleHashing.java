import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class DoubleHashing {

    private DataItem [] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public DoubleHashing(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {

        System.out.println("Table: ");
        for(int i=0; i < arraySize; i++){
            if (hashArray[i] != null )
                System.out.println(hashArray[i].getKey()+ " ");
            else
                System.out.println("null or ***");
        }
        System.out.println(" ");


    }

    public int hashFunc1(int key){
        return key % arraySize;
    }


    public int hashFunc2(int key){
        // array size must be relatively prime to 5,4,3,2

        return 5 - key % 5;
    }


    public void insert(int key, DataItem item){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key); // Get step size until empty cell or -1

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){

            hashVal += stepSize;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    } // end insert


    public DataItem delete(int key){

        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem  temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;

            }

            hashVal += stepSize;
            hashVal %= arraySize;

        }
        return null;

    }


    public DataItem find(int key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);


        while( hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            if (hashArray[hashVal].getKey() == key){
                //System.out.println("Item found");
                return hashArray[hashVal]; // return the item

            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }




    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        DataItem dataItem;
        int aKey, size, n;

        System.out.println("Enter size of hashTable");
        size = in.nextInt();


        System.out.println("Enter initial number of items");
        n = in.nextInt();


        DoubleHashing doubleHashing = new DoubleHashing(size);


        for(int i=0; i<n;i++){
            aKey = (int) (java.lang.Math.random() * 1 * size );
            dataItem = new DataItem(aKey);
            doubleHashing.insert(aKey,dataItem);


        }

        while(true){
            System.out.println("Enter first letter of");
            System.out.println("show,insert,delete and find");

            String aStr = in.next();
            char ch = aStr.charAt(0);
            switch(ch){
                case 's':
                        doubleHashing.displayTable();
                        break;
                case 'i':
                        System.out.println("Enter element to insert\n");
                        int val = in.nextInt();
                        DataItem item = new DataItem(val);
                        doubleHashing.insert(val,item);
                        break;
                case 'd':
                        System.out.println("Enter element to delete");
                        val = in.nextInt();
                        doubleHashing.delete(val);
                        break;
                case 'f':
                        System.out.println("Enter element to find");
                        aKey = in.nextInt();
                        dataItem = doubleHashing.find(aKey);

                        if(dataItem != null){
                            System.out.println("Found "+aKey);
                        }else
                            System.out.println("Not found");
                        break;



            }
        }





    }

}