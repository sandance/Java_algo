import java.util.*;


/**
 * Created by nazmul on 12/15/14.
 */
 class CGPAComparator implements Comparator<Student>{

    public int compare (Student s1, Student s2){
        return (s1.cgpa.compareTo(s2.cgpa));
    }
    
}
