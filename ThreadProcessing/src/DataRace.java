import java.lang.Thread.*;

/**
 * Created by nazmul on 12/22/14.
 */

class Counter {
    public static long count =0;
}


 class UseCounter implements  Runnable {
    public synchronized void increment () {
       // synchronized (this) {
            Counter.count++;
            System.out.println(Thread.currentThread().getName() + "\tfinds \t" + Counter.count + " ");
        } // lock ends here
   // }

    public void run() {
        increment();
        increment();
        increment();

    }

}

public class DataRace {
    public static void main(String [] args) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();

    }
}
