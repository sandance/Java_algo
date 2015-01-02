
import java.lang.Thread.*;


/**
 * Created by nazmul on 12/22/14.
 */
class Waiter extends Thread {
    public void getCoffee(){
        synchronized (CoffeeMachine.lock){
            if(CoffeeMachine.coffeeMade  == null) {
                try {
                    System.out.println("Waiter: Will get orders till coffee machine");
                    CoffeeMachine.lock.wait();
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }

        System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
        CoffeeMachine.coffeeMade = null;
        CoffeeMachine.lock.notifyAll();
        System.out.println("waiter: Notifying coffee machine to make another one");

    }

    public void run(){
        while(true){
            getCoffee();
        }
    }


}
