import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;







public class HashTable {

    private DataItem [] hashArray; //This array holds hashTable
    private  int  arraySize;

    private  DataItem nonItem; // For Deleted items


    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key i
    }

    public void displayTable() {
        System.out.println("Table: ");
        for(int i=0; i < arraySize;i++){
            if( hashArray[i] != null){
                System.out.println(hashArray[i].getKey() +" "  );

            }
            else
                System.out.println("**");

        }
        System.out.println("");
    }

    public int hashFunc(int key){
        return key % arraySize; //hash function
    }

    // Insert a element into the HashTable
    public void insert(DataItem item){
        int key = item.getKey(); //extract key
        int hashVal = hashFunc(key);




        // Until emptry cell is found or -1 found, look for empty place

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++ hashVal;
            hashVal %= arraySize ; // modulus

        }
        // if null found , store the value there
        hashArray[hashVal] = item;

    } // end insert


    public DataItem delete (int key){

        // hash the key first

        int hashVal = hashFunc(key);

        // search for it

        while(hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++ hashVal;
            hashVal %= arraySize;
        }
        return null;
    } // end delete


    /**
     *
     * @param key
     * @throws IOException
     * reutrn valuePosition
     */

    public DataItem find(int key){

        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null ) {
            //until empty cell is found
            if(hashArray[hashVal].getKey() == key ){
                return hashArray[hashVal]; // yes, return item
            }
            ++ hashVal;
            hashVal %= arraySize;
        }
        return  null;
    }









    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        DataItem aDataItem ;
        int aKey, size,n,KeyPerCell=10;

        System.out.println("Enter size of the hash Table");
        size = in.nextInt();

        System.out.println("Enter initial number of items");
        n = in.nextInt();

        HashTable theHashTable = new HashTable(size);

        // insert data

        for(int i=0; i< n;i++){
            aKey = (int) (java.lang.Math.random() * KeyPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);

        }


        // interact with the user

        while(true){
            System.out.println("Enter First letter of \n");
            System.out.print("show, insert,delete or find");

            String ch = in.nextLine();
            char choice = ch.charAt(0);

            switch (choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert");
                    aKey = in.nextInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete");
                    aKey = in.nextInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter key value to find");
                    aKey = in.nextInt();
                    aDataItem = theHashTable.find(aKey);

                    if (aDataItem != null){
                        System.out.println("found " + aKey);
                    }
                    else
                        System.out.println("Could not find" + aKey);
                    break;

                default:
                    System.out.println("Invalid entry\n");



            }
        }

    }

}