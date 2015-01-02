import java.io.IOException;
import java.lang.Thread.*;

/**
 * Created by nazmul on 12/22/14.
 */
public class MyThread2Runnable implements Runnable {

    public void run() {
            System.out.println("In run method: thread name is : "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws IOException {
        Thread myThread = new Thread(new MyThread2Runnable());
        myThread.start();

        System.out.println("In main method: thread name is "+ Thread.currentThread().getName());

    }


}
