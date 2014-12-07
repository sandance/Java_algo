/**
 * Created by nazmul on 12/6/14.
 */
public class Link {
    private int iData;
    public Link next;

    public Link(int i){
        iData = i;

    }

    public int getKey(){
        return iData;
    }

    public void displayLink() {
        System.out.println(iData+"\n");
    }

}
