import java.lang.Thread.*;


/**
 * Created by nazmul on 12/22/14.
 */
class CoffeeMachine  extends Thread {
    static String coffeeMade = null;
    static final Object lock = new Object();

    private static int coffeeNumber = 1;

    void makeCoffee() {
        synchronized (CoffeeMachine.lock) { //get the lock
            if (coffeeMade != null) {
                try {
                    System.out.println("Coffee Machine: Waiting for waiter" +
                            "to deliver the coffee ");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            //otherwise make coffee
            coffeeMade = "Coffee No " + coffeeNumber++;
            System.out.println("Coffee machine says : Made " + coffeeMade);
            // once the coffee is ready, notify the waiter to pick it up
            CoffeeMachine.lock.notifyAll();
            System.out.println("Coffee Machine: Notify waiter to pick the office");
        } // critical section ends here

    }


    public void run(){
        while (true){
            makeCoffee();
            try{
                System.out.println("Coffee machine: Making another coffee now");
                Thread.sleep(10000);
            } catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
