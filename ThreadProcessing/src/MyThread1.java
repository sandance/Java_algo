import java.lang.Thread.*;

/**
 * Created by nazmul on 12/22/14.
 */
public class MyThread1 extends Thread {

    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("In run method; thread name is : \n" + getName());
    }



    public static void main(String[] args){
        Thread myThread = new MyThread1();
        System.out.println("Just after creating thread; \n" + myThread.getState());

        myThread.start();
        System.out.println("Just after calling thread' \n" + myThread.getState());

        try {
            myThread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Just after main calling \n" + myThread.getState());
        System.out.println("In main method: thread name is: " + Thread.currentThread().getName());
    }


}