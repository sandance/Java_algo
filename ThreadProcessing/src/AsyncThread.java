import java.io.IOException;
import java.util.*;



/**
 * Created by nazmul on 12/22/14.
 */
public class AsyncThread extends Thread {

        public void run() {
            System.out.println("Starting the thread " + getName());

            for(int i=0;i<3;i++){
                System.out.println("In thread: "+getName() + "; iteration " + i);
                try {
                        // sleep for sometime before next iteration
                        Thread.sleep(10);
                } catch(InterruptedException ex){
                    // we are not interrupting any threads

                    // so safe to ignore this exception
                    ex.printStackTrace();
                }
            }
        }


        public static void main(String [] args) throws IOException {
            AsyncThread asyncThread1 = new AsyncThread();
            AsyncThread asyncThread2 = new AsyncThread();

            asyncThread1.start();
            asyncThread2.start();
    }

}
