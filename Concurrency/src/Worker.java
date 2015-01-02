import java.util.concurrent.*;

/**
 * Created by nazmul on 12/30/14.
 */
class Worker extends Thread {
        Phaser deliveryOrder;

        Worker(Phaser order, String name){
            deliveryOrder = order;
            this.setName(name);
            deliveryOrder.register();
            start();
        }

        public void run() {
            for(int i=1;i<= 3; i++){
                System.out.println("\t" + getName() + "doing his work for order no." + i);
                if ( i==3)
                    deliveryOrder.arriveAndDeregister();
                else
                    deliveryOrder.arriveAndAwaitAdvance();

                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }

}
