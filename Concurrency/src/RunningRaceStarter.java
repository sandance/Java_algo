import java.util.concurrent.*;


/** This class simulates the start of a running race by counting down from 5
 * It holds three runner to be ready to start in the start line of the race and once the count
 * down reaches zero, all the three runners start running....
 *
 *
 * Created by nazmul on 12/29/14.
 */
public class RunningRaceStarter {
        public static  void main(String [] args ) throws InterruptedException {
            CountDownLatch counter = new CountDownLatch(5);
            // count from 5 to 0 and then start the race

            // instantiate three runner threads
            new Runner(counter, "Carl");
            new Runner(counter, "Joe");
            new Runner(counter," Jack");


            System.out.println("Starting the countdown");
            long countVal = counter.getCount();

            while(countVal > 0){
                Thread.sleep(1000); // 1000 ms = 1sec
                System.out.println(countVal);

                if (countVal == 1){
                    System.out.println("Start");

                }
                counter.countDown();
                countVal = counter.getCount();
            }

        }
}
