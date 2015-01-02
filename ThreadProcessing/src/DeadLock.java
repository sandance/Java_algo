import java.util.*;


/**
 * Created by nazmul on 12/22/14.
 */

// Ball class has a globally accessible data member to hold the number of balls thrown so far

class Balls {
    public static long balls = 0;
}

class Runs {
    public static long runs =0;
}


class Counters implements Runnable {
    public void IncrementBallAfterRun() {
        synchronized (Runs.class){
            synchronized (Balls.class){
                Runs.runs++;
                Balls.balls++;

            }
        }
    }

    public void IncrementRunAfterBall() {
        synchronized (Balls.class){
            synchronized (Runs.class){
                Balls.balls++;
                Runs.runs++;
            }
        }
    }

    public void run(){
        // call these two methods which acquire locks in different order
        // depending on thread scheduling and the order of lock acquision
        // a deadlock may or may not arise
        IncrementBallAfterRun();
        IncrementRunAfterBall();
    }
}



public class DeadLock {
    public static void main(String [] args) throws InterruptedException {
        Counters c = new Counters();

        Thread  t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
        System.out.println("Waiting for threads to complete execution...");
        t1.join();
        t2.join();
        System.out.println("Done.");
    }
}
