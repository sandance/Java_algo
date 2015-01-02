import java.lang.Thread.*;


/**
 *
 * Created by nazmul on 12/22/14.
 */
class CoffeeMachine extends Thread {

    static String cofferMade = null;
    static final Object lock = new Object();

    private static int coffeeNumber =1;

    void makeCoffee(){
        synchronized (CoffeeMachine.lock){
            if(cofferMade !=null){
                try {
                        System.out.println("Coffee machine : waiting for waiter notification to deliver");
                        CoffeeMachine.lock.wait();

                } catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }

            cofferMade = "Coffee No: " + coffeeNumber ++;
            System.out.println("Coffee machine says: Made" + cofferMade);
            CoffeeMachine.lock.notifyAll();
            System.out.println("Coffee machine : Notifying waiter to pick the coffee");

        }

    }


    public void run() {
        while(true){
            makeCoffee();

            try {
                System.out.println("Coffe machine: Making another coffe now");
                Thread.sleep(10000);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

}
