import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by nazmul on 12/29/14.
 */
public class Player extends Thread {
    CyclicBarrier waitPoint;

    public Player(CyclicBarrier barrier, String name){
        this.setName(name);
        waitPoint = barrier;
        this.start(); // start the thread
    }

    public void run(){
        System.out.println("Player " + getName() + "is ready");

        try {
            waitPoint.await(); // await for all four players to arrive

        } catch (InterruptedException ie){
            ie.printStackTrace();
        } catch (BrokenBarrierException bie){
            System.out.println("An exception occurred while waiting .. " + bie);
        }
    }

}
