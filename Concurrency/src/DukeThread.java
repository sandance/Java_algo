import java.util.concurrent.Exchanger;


/** This DukeThread class runs as an independent thread. It talks to the coffeeShopThread that also
 * runs independently . The chat is achieved by exchanging messages through a common Exchange object
 * that synchronizes the chat between them.
 *
 * Created by nazmul on 12/29/14.
 */
public class DukeThread extends Thread {
     private Exchanger<String> sillyTalk;

    public DukeThread(Exchanger<String> args){
        sillyTalk = args;
    }

    public void run(){
        String reply = null;

        try {
            // Start the conversation with CoffeeShop Method
            reply = sillyTalk.exchange("Knock knock");
            System.out.println("CoffeeShop: " + reply);

            // exchange another set of messages

            reply = sillyTalk.exchange("Duke");
            System.out.println("CoffeeShop : " + reply);


            reply = sillyTalk.exchange("The one who was born in this coffee shop!");

        } catch (InterruptedException ie){
            System.out.println("Got interuppted during my silly talk");
        }
    }

}
