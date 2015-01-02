import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RawTest {
        public  static void main(String[] args){
            List list = new LinkedList();
            list.add("First");

            list.add("second");

            List<String> strList = list;

            for(Iterator<String> itemItr = strList.iterator(); itemItr.hasNext();)
                System.out.println("Item: "+ itemItr.next());
        }
}