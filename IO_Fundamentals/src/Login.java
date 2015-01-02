import java.io.Console;
import java.util.Arrays;


/**
 * Created by nazmul on 12/22/14.
 */
class Login {
    public static void main(String[] args){
        Console console = System.console();
        if(console != null){
            String userName = null;
            char [] password = null;

            userName = console.readLine("Enter your username: ");
            password = console.readPassword("Enter password: ");

            if(userName.equals("scrat") && new String(password).equals("nuts")){
                console.printf("login successful!");
            }else
                console.printf("restart application and try again");
        }
    }

}
