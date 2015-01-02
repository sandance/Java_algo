import java.util.concurrent.Semaphore;

/** Each person is an independent thread
 * But their access to the common resource needs to be synchronized
 *
 * Created by nazmul on 12/29/14.
 */
class Person extends Thread {
    private Semaphore machines;

    public Person(Semaphore machines, String name){
            this.machines = machines;
            this.setName(name);
            this.start();
    }

    public void run() {
        try {
            System.out.println(getName() + "waiting to access an ATM machine");
            machines.acquire();
            System.out.println(getName() + "is accessing an ATM machine");
            Thread.sleep(1000);
            System.out.println(getName() + " is done using the ATM machine");
            machines.release();
        } catch (InterruptedException ie){
            System.err.println(ie);
            ie.printStackTrace();
        }
    }

}
