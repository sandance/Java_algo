import java.util.*;



/**
 * Created by nazmul on 8/6/14.
 */
public class UnionFind <T> {

    /**
     * A utility struct holding an objects parent and rank
     *
     */

    private static final class Link<T> {

        public T parent;
        public int rank=0;

        /* Creates a new Link object with the specified parent
         */

        Link(T parent){
            this.parent = parent;
        }

    }

    /**
     * A map from objects in the UnionFind structure to their associated rank and parent
     */

    private final Map<T,Link<T>> elems = new HashMap<T, Link<T>>();

    public UnionFind() {

    }


    /**
     * Creates a new UnionFind structure that initially contains all of  the elements from the specified
     * container.
     */

    public UnionFind(Collection<? extends T> elems ) {

        /* Iterate across the collection , adding each to this structure */
        for(T elem: elems)
            add(elem);

    }

    /**
     * Inserts a new element into the UnionFind structure that initially
     * is in its own partition . If the element already exist , this function returns false.
     *
     * Otherwise , it returns true
     */

    public boolean add(T elem){

        /* Check for null */
        if (elem == null)
            throw new NullPointerException("Union does not support null");
        /* Check whether this entry exists; fail if it does */

        if (elems.containsKey(elem))
            return false;
        /* check whether this entry exists , fail if it does */

        /* Otherwise add the element as its own parent */

        elems.put(elem,new Link<T>(elem));
        return true;

    }

    /**
     * Given an element, returns the representative element of the set
     * containing that element.
     * @param elem the element to look up
     * @return the representative of the set containing the element
     *
     */

    public T find(T elem){

        /* Check whether the element exists, fail if it doesn't */

        if (!elems.containsKey(elem))
            throw new NoSuchElementException(elem+" is not an element");

        /* Recursively search the structure and return the result */

        return recFind(elem);
    }

    private T recFind(T elem){
        /* Get the info on this object */
        Link<T> info = elems.get(elem);

        /*
        If the element is its own parent, it is representaitve of its
        class and we should say so
        */

        if(info.parent.equals(elem))
            return elem;

        /**
         * Otherwise, look up the parent of this element, then compress the path
         */
         info.parent = recFind(info.parent);

         return info.parent;

    }

    /**
     * Given two elements, union together the sets containing those elements
     * @param one  The first element to link
     * @param two  The second element to link
     * @throws java.util.NoSuchElementException if either element does not exist
     *
     */

      public void union (T one , T two ){

          /* Get the link info for the parents */
          Link<T> oneLink = elems.get(find(one));
          Link<T> twoLink = elems.get(find(two));

          /* if these are same object, we are done */

          if(oneLink == twoLink)
              return;

          /**
           * Otherwise, link the two, We'll do a union by rank, where the parent with lower
           * rank will merge with the parent with higher rank
           *
           */

           if (oneLink.rank > twoLink.rank) {

               /* Since each parent must link to itself, the value of oneLink.parent
                 is the representative of one
                */

               twoLink.parent = oneLink.parent;

           } else if (oneLink.rank < twoLink.rank) {

                oneLink.parent = twoLink.parent;

           } else {
               /* Arbitarily wire one to be the parent of two */

               twoLink.parent = oneLink.parent;
               oneLink.rank++;
           }



      }



}
