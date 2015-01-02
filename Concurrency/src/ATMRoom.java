import java.util.concurrent.Semaphore;

/**
 * Created by nazmul on 12/29/14.
 */
public class ATMRoom {
    public static  void main(String[] args){
        Semaphore machines = new Semaphore(2);
        new Person(machines,"Micky");
        new Person(machines,"Donald");
        new Person(machines,"Tom");
        new Person(machines,"Jerry");
        new Person(machines,"Casper");

    }
}
