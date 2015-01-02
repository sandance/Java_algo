import java.util.concurrent.*;


/**
 * Created by nazmul on 12/30/14.
 */
public class ProcessOrder {
    public static void main(String[] args) throws InterruptedException {
                Phaser deliveryOrder = new Phaser(1);
                // phaser is the synchronizer to make food items one by one and move
                // deliver it before moving to the next item

                new Worker(deliveryOrder, "Cook");
                new Worker (deliveryOrder, "Helper");
                new Worker (deliveryOrder, "Attendant");


                for(int i=1; i<=3;i++){
                    // Prepare, mix and deliver this food item
                    deliveryOrder.arriveAndAwaitAdvance();
                    System.out.println("deliver food item no:" + i);
                }

                // work completed for this delivery, so deregister
                deliveryOrder.arriveAndDeregister();
                System.out.println("Delivery order completed");




    }
}
