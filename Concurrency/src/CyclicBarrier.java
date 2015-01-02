import java.util.concurrent.*;


/**
 * Created by nazmul on 12/29/14.
 */
class CyclicBarrierTest {

    public static void main(String[] args) {
        // a mixed double tennis game requires four players , so wait for four players to join to start the game

        System.out.println("Reserving tennis court \n As soon as four players arrive");
        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
        new Player(barrier, "G I Joe");
        new Player(barrier, "Dora");
        new Player(barrier, "Tintin");
        new Player(barrier, "Barbie");
    }
}
