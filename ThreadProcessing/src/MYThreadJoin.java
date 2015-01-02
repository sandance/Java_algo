import java.lang.*;

/**
 * Created by nazmul on 12/22/14.
 */
public class MYThreadJoin extends Thread {
        String [] timeStr =     { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

        public void run() {
            for(int i=9;i>= 0;i--){
                try {
                    System.out.println(timeStr[i]);
                    Thread.sleep(1000);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }


    public static void main(String[] args) {
        //Thread MYThreadJoin = new Thread(new MYThreadJoin());
        System.out.println("Stating 10 second count down..");
        MYThreadJoin timer = new MYThreadJoin();
        timer.start();
        try {
            timer.join();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Boom!");
    }

}
