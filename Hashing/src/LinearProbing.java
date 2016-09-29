/**
 * Created by NIslam on 9/24/16.
 */
import java.util.ArrayList;

public class LinearProbing<K,V> implements HashTable <K,V> {
    public ArrayList<Entry<K,V>> hashTable;
    public ArrayList<K> keys;
    public static int step, numberOfEntries, tableSize;
    public double loadFactor;
    public int numberOfCollisions, totalCollisions;
    public boolean rehashing;


    public LinearProbing() {
        rehashing = false;
        numberOfCollisions = 0;
        totalCollisions = 0;
        numberOfEntries = 0;
        tableSize = 10;
        loadFactor = 0;
        step = getRelativePrimeStep();
        hashTable = new ArrayList<Entry<K,V>>();

        for(int i=0; i < tableSize ; i++)
            hashTable.add(null);
    }

    public int getRelativePrimeStep(){
        for(int i=2; i<tableSize;i++)
            if (getGCD(i)==1)
                return i;
        return 1;
    }

    public int getGCD(int b){
        int a = this.tableSize;
        int temp;

        while(b>0){
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int searchForEntry(K key){
        int index;
        int homePosition = key.hashCode() % tableSize;

        for(int i=0; i< tableSize;i++){
            index = (homePosition + i * step) % tableSize;
            if( hashTable.get(index) == null)
                return -1;
            else if (hashTable.get(index).isTompStone())
                continue;
            else if (key.hashCode() == hashTable.get(index).getKey().hashCode())
                return index;

        }
        return -1;
    }

    @Override
    public void put(K key, V value){
        int positionInfo = searchForEntry(key);
        // does not exist before
        if (positionInfo == -1){
            int homePosition = key.hashCode() % tableSize;

            int index;
            // find empty position in the probe
            for (int i=0; i < tableSize; i++){
                index = ( homePosition + i * step) % tableSize;

                if (hashTable.get(index) == null || hashTable.get(index).isTompStone()){
                    hashTable.set(index, (new Entry<K, V>(key, value)));

                    if (!rehashing && index != homePosition)
                        numberOfCollisions++;
                    numberOfEntries++;
                    checkForRehashing();
                    return;
                }
            }
            System.out.println("Unable to put entry, Memory Full");

        }
        else
            hashTable.get(positionInfo).setValue(value);
    }

    public void checkForRehashing(){
        // calculate load factor
        loadFactor = (double) numberOfEntries % tableSize;
        if (loadFactor >= 0.75)
            rehash();
    }


    public void rehash(){
        totalCollisions += numberOfCollisions;
        numberOfCollisions = 0;
        rehashing = true;
        ArrayList<Entry<K,V>> preHashTable = hashTable;

        numberOfEntries = 0;
        tableSize *= 2;
        loadFactor = 0;
        step = getRelativePrimeStep();
        hashTable = new ArrayList<Entry<K,V>>();

        for(int i=0; i < tableSize; i++)
            hashTable.add(null);

        for(int i=0; i < preHashTable.size(); i++){
            if ( preHashTable.get(i) != null && !preHashTable.get(i).isTompStone())
                put(preHashTable.get(i).getKey(), preHashTable.get(i).getValue());
        }
        rehashing = false;
    }

    @Override
    public V get(K key){
        int positionInfo = searchForEntry(key);
        if (positionInfo != -1)
            return hashTable.get(positionInfo).getValue();
        return null;
    }

    @Override
    public void delete(K key){
        int positionInfo = searchForEntry(key);

        if(positionInfo != -1){
            hashTable.get(positionInfo).setTompStone(true);
            numberOfEntries --;

        }
    }

    @Override
    public boolean contains(K key){
        int positionInfo = searchForEntry(key);

        if (positionInfo != -1)
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
            if (hashTable.get(i) != null && hashTable.get(i).isTompStone())
                keys.add(hashTable.get(i).getKey());
        }
        return keys;

    }

    @Override
    public int size(){
        return numberOfEntries;
    }

    @Override
    public int tableLength(){
        return tableSize;
    }

    @Override
    public int getNumOfCollisions() {
        return numberOfCollisions;
    }
    @Override
    public int getMemoryUsed()
    {
        return tableSize;
    }

    @Override
    public int getTotalCollisions(){
        return totalCollisions;
    }

}
