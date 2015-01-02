import java.util.*;

/**
 * Created by nazmul on 12/19/14.
 */
public class ChaniedException {
    public static void foo() {
        try {
            String[] str = {"foo"};
            System.out.println("About to throw ArrayIndexBoundsException");
            String functionName = str[10];

        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println("Wrapping ArrayIndexOutOfBoundsException into a RuntimeExp");
            throw new RuntimeException(oob);
        }

    }

    public static void main(String[] args) {
        try {
            foo();
        } catch (Exception re) {
            System.out.println("The caught exception in main is: " + re.getClass());
            System.out.println("The cause of the Exception is : " + re.getCause());
        }

    }
}
