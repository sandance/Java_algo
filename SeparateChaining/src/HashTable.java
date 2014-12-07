import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nazmul on 12/6/14.
 */
public class HashTable {

    private  SeparateChaining [] hashArray; // array of lists

    private  int arraySize;

    public HashTable(int size){
        arraySize= size;
        hashArray = new SeparateChaining[arraySize]; // create array
        for(int i=0;i<arraySize;i++){
            hashArray[i] = new SeparateChaining();
        }


    }

    public void displayTable(){
        for(int i=0;i<arraySize;i++){
            System.out.println(i+" "); // display cell number
            hashArray[i].displayList(); // display list
        }
    }


    public int hashFunc(int key){
        return key % arraySize;
    }


    /**
     * Java Method to store any string key into the hashTable
     * @param theLink
     */

    public  int hashFunc_string(String key) {
        int hashVal = 0;
        int pow27 = 1;

        for (int i = key.length() - 1; i >= 0; i--) { // right to left
            int letter = key.charAt(i) - 96; // get char code
            hashVal += pow27 * letter;
            pow27 *= 27;


        }
        return hashVal % arraySize;
    } // works for string

    public void insert(Link theLink) {      // insert a link
        int key = theLink.getKey();

        int hashVal = hashFunc(key);        // hash the key

        hashArray[hashVal].insert(theLink); // insert at hashVal

    }

    public void delete(int key){
        int hashVal = hashFunc(key);

        hashArray[hashVal].delete(key);

    } // end delete



    public Link find(int key){
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }

    public static void main(String[] args) throws IOException {
        int aKey;

        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        Link dataItem;
        int size,n,keysPerCell = 100;

        System.out.println("Enter size of hash Table");
        size = in.nextInt();

        System.out.println("Enter initial number of items");
        n = in.nextInt();


        HashTable hashTable = new HashTable(size);

        for(int i=0;i<n;i++){
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            dataItem = new Link(aKey);
            hashTable.insert(dataItem);


        }


        while(true){

                System.out.print("Enter first letter of");
                System.out.print("show, insert, delete, or find: ");

                String a = in.next();
                char ch = a.charAt(0);

                switch (ch){

                    case 's':
                        hashTable.displayTable();
                        break;
                    case 'i':
                        System.out.println("Enter item to insert");
                        aKey = in.nextInt();
                        dataItem = new Link(aKey);
                        hashTable.insert(dataItem);
                        break;

                    case 'd':
                        System.out.println("enter key to delete");
                        aKey = in.nextInt();
                        hashTable.delete(aKey);
                        break;
                    case 'f':
                        System.out.println("Enter key value to find");
                        aKey = in.nextInt();
                        dataItem = hashTable.find(aKey);

                        if (dataItem != null){
                            System.out.println("Found "+aKey);

                        }else
                            System.out.println("Could not find" + aKey);
                        break;
                    default:
                        System.out.println("Invalid entry\n");
                }


        }

    }
}
