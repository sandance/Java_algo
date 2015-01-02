

/**
 * Created by nazmul on 12/22/14.
 */


/**
 * The waiter runs as a independent thread.  It interacts with the CoffeeMachine to wait for a coffe
 * And delivers the coffee once ready and request the coffee machine for the next one
 */
public class Waiter extends  Thread {
    public void getCoffee(){
        synchronized (CoffeeMachine.lock){
            if (CoffeeMachine.cofferMade == null){
                try {
                    System.out.println("Waiter: Will get orders till coffee machine notifies me");
                    CoffeeMachine.lock.wait();
                } catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
            System.out.println("waiter: Delivering " + CoffeeMachine.cofferMade);
            CoffeeMachine.cofferMade = null;
            CoffeeMachine.lock.notifyAll();
            System.out.println("waiter: notify coffee machine to make another one");
        }
    }

    public void run() {
        while(true){
            getCoffee();
        }
    }

}
