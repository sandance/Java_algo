import java.util.concurrent.CountDownLatch;

/** This runner class simulates a track runner in a 100 meter dash race.
 * the runner waits until the count down timer gets to zero and then starts running
 *
 * Created by nazmul on 12/29/14.
 */
public class Runner extends Thread {
    private CountDownLatch timer;

    public Runner(CountDownLatch cdl, String name){
        timer = cdl;
        this.setName(name);
        System.out.println(this.getName() + "\t ready and waiting for the count down to start");
        start();
    }

    public void run() {
        try {
            // wait for the timer count down to reach 0
            timer.await();

        } catch (InterruptedException ie){
            System.out.println("interrupted -- cant start running the race");
        }
        System.out.println(this.getName() + "started running");
    }



}
