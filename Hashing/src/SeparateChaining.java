/**
 * Created by NIslam on 9/20/16.
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class SeparateChaining <K,V> implements HashTable <K,V> {
    //array of Linked Lists
    private ArrayList <LinkedList <Entry<K,V> > > hashTable;
    private ArrayList<K> keys;

    private int numberOfEntries, tableSize;
    private double loadFactor;

    private int numOfCollisions, totalCollisions;
    private boolean rehashing;

    public SeparateChaining() {
        rehashing = false;
        numberOfEntries = 0;
        numOfCollisions = 0;
        totalCollisions = 0;

        tableSize = 10;
        loadFactor = 0;

        hashTable = new ArrayList< LinkedList<Entry<K,V>>>();
        // initialize Linked List
        for(int i=0;i < tableSize; i++ ) {
            hashTable.add(new LinkedList<Entry<K, V>>());
        }

    }

    @Override
    public void put(K key, V value){
        // check if already exist
        int [] positionInfo = searchForEntry(key);

        // doesn't exist before
        if (positionInfo == null){
            // get index
            int homePosition = key.hashCode() % tableSize;

            if(!rehashing && hashTable.get(homePosition).size() !=0)
                numOfCollisions++;

            // insert into LinkedList
            hashTable.get(homePosition).add(new Entry<K,V>(key, value));

            // increment num of entries
            numberOfEntries++;

            // check load factor
            checkForRehashing();
        }
        else{
            hashTable.get(positionInfo[0]).get(positionInfo[1]).setValue(value);
        }
    }

    private int [] searchForEntry(K key){
        // if not found return null else return index
        int homePosition = key.hashCode() % tableSize;

        // get chain length
        int chainSize = hashTable.get(homePosition).size();

        // searching the chain
        for(int i=0; i < chainSize; i++){
            if(hashTable.get(homePosition).get(i).getKey().hashCode() == key.hashCode()){
                int [] positionInfo = { homePosition, i };
                return positionInfo;
            }
        }
        return null;
    }

    private void checkForRehashing() {
        // calculate load factor
        loadFactor = (double) numberOfEntries / tableSize;
        if (loadFactor >= 3)
            rehash();
    }

    private void rehash() {
        totalCollisions += numOfCollisions;
        numOfCollisions = 0;
        rehashing = true;

        ArrayList< LinkedList<Entry<K,V> > > prevHashTable = hashTable;
        tableSize *= 2;
        loadFactor = 0;
        numberOfEntries = 0;
        hashTable = new ArrayList< LinkedList<Entry<K,V> > >();

        for(int i=0; i < tableSize; i++)
            hashTable.add(new LinkedList<Entry<K, V>>());

        for(int i=0; i < prevHashTable.size(); i++){
            for(int j=0; j < prevHashTable.get(i).size(); j++) {
                put(prevHashTable.get(i).get(j).getKey(), prevHashTable.get(i).get(j).getValue());
            }
        }
        rehashing = false;
    }

    @Override
    public V get(K key){
        int [] positionInfo = searchForEntry(key);

        if(positionInfo!= null){
            // get index
            int homePosition = positionInfo[0];
            // get position in the linked list
            int index = positionInfo[1];

            return hashTable.get(homePosition).get(index).getValue();

        }
        return null;
    }

    @Override
    public void delete(K key){
        int [] positionInfo = searchForEntry(key);

        if(positionInfo!=null){
            // get index
            int homePosition = positionInfo[0];

            // get position in the LinkedList
            int index = positionInfo[1];
            hashTable.get(homePosition).remove(index);
            numberOfEntries--;
            return;
        }
        System.out.println("Unable to delete. Entry not Found.");

    }

    @Override
    public boolean contains(K key){
        int [] positionInfo = searchForEntry(key);

        if (positionInfo!=null)
            return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries==0);
    }

    @Override
    public Iterable<K> keys() {
        keys = new ArrayList<K>();
        for(int i=0; i < tableSize; i++){
            for(int j=0;j < hashTable.get(i).size() && hashTable.get(i) != null; j++){
                keys.add(hashTable.get(i).get(j).getKey());
            }
        }
        return keys;
    }

    @Override
    public int size(){
        return numberOfEntries;
    }

    @Override
    public int tableLength() {
        return tableSize;
    }

    @Override
    public int getNumOfCollisions(){
        return numOfCollisions;
    }

    @Override
    public int getMemoryUsed() {
        int totalMemory = tableSize;

        for(int i=0; i < tableSize; i++){
            totalMemory += hashTable.get(i).size();
        }
        return totalMemory;
    }

    @Override
    public int getTotalCollisions() {
        return totalCollisions;
    }


}
