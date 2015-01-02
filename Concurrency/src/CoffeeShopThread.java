import java.util.concurrent.Exchanger;

/**
 * Created by nazmul on 12/29/14.
 */
public class CoffeeShopThread extends  Thread {
    private Exchanger<String> sillyTalk;

    public CoffeeShopThread(Exchanger<String> args){
        sillyTalk = args;
    }

    public void run() {
        String reply = null;

        try {
            // excahnge first message
            reply = sillyTalk.exchange("who's there?");

            // print what Duke said
            System.out.println("Duke : " + reply);

            // exchnage second method
            reply = sillyTalk.exchange("Duke who?");
            System.out.println("Duke "+ reply);
        } catch (InterruptedException ie){
            System.err.println("Got interrupted during my silly talk");
        }
    }
}
