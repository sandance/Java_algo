/**
 * Created by nazmul on 12/22/14.
 */
public class CoffeShop {

    public static void main(String [] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Waiter waiter = new Waiter();
        coffeeMachine.start();
        waiter.start();
    }
}
