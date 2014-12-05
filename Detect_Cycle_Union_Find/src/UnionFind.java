import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.*;



/**
 * Created by nazmul on 8/6/14.
 */
public class UnionFind<T> {

    public static final class Link<T> {

        public T parent;
        public int rank=0;

        Link(T parent){
            this.parent = parent;
        }

    }


    /**
     * A map from objects in the UnionFind structure to their associated rank and parent
     */

    private final Map<T,Link<T>> elems = new HashMap<T, Link<T>>();

    public UnionFind() {
        // nothing here
    }


    /**
     * Creates a new UnionFind structure that initially contains all the elements  from
     * the specified container
     *
     * @param  elems The elements to store in the UnionFind Structure
     */

    public UnionFind(Collection<? extends T> elems) {

        /*Iterate accross the Collection , adding each to this structure */
        for(T elem : elems)
            add(elem);

    }

    public boolean add(T elem){
        if(elem == null){
            throw new NullPointerException("UnionFind does not support null");

        }

        /* Check whether this entry exist, fail if it does */

        if(elems.containsKey(elem)){
            return false;
        }

        /* Otherwise add the element as its own parent */

        elems.put(elem,new Link<T> (elem));
        return true;
    }


    public T find(T elem) {

        if(!elems.containsKey(elem))
            throw new NoSuchElementException(elem + " is not a element");

        return recFind(elem);

    }

    public T recFind(T elem) {

        Link<T> info = elems.get(elem);


        /* If the element is its own parent, it's the representative of its
         * class and we should say so.
         */
        if (info.parent.equals(elem))
            return elem;

        /* Otherwise, look up the parent of this element, then compress the
         * path.
         */
        info.parent = recFind(info.parent);
        return info.parent;
    }

    public void union(T one, T two) {
        /* Get the link info for the parents.  This also handles the exception
         * guarantee.
         */
        Link<T> oneLink = elems.get(find(one));
        Link<T> twoLink = elems.get(find(two));

        /* If these are the same object, we're done. */
        if (oneLink == twoLink) return;

        /* Otherwise, link the two.  We'll do a union-by-rank, where the parent
         * with the lower rank will merge with the parent with higher rank.
         */
        if (oneLink.rank > twoLink.rank) {
            /* Since each parent must link to itself, the value of oneLink.parent
             * is the representative of one.
             */
            twoLink.parent = oneLink.parent;
        } else if (oneLink.rank < twoLink.rank) {
            /* Same logic as above. */
            oneLink.parent = twoLink.parent;
        } else {
            /* Arbitrarily wire one to be the parent of two. */
            twoLink.parent = oneLink.parent;

            /* Bump up the representative of one to the next rank. */
            oneLink.rank++;
        }
    }


}
