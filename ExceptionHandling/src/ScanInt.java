import java.io.IOException;
import java.util.*;
/**
 * Created by nazmul on 12/19/14.
 */
public class ScanInt {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        System.out.println("Type an integer in the console\n");
        try{
            System.out.println("You typed the integer value: " + in.nextInt());
        } catch (InputMismatchException e){
            //e.printStackTrace();
            System.out.println("Error: an Error occured while attempting to scan ");
        } finally {
            System.out.println("Done reading the integer , closing the scanner\n");
            in.close();
        }
    }
}
