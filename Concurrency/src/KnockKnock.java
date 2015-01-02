import java.util.concurrent.Exchanger;

/**
 * Created by nazmul on 12/29/14.
 */
public class KnockKnock {
    public static void  main(String [] args){
        Exchanger<String> sillyTalk = new Exchanger<String>();
        new CoffeeShopThread(sillyTalk).start();
        new DukeThread(sillyTalk).start();

    }

}
