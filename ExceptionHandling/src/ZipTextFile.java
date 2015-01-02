import java.util.*;
import java.util.zip.*;
import java.io.*;
/**
 * Created by nazmul on 12/19/14.
 */
public class ZipTextFile {

    public static final int CHUNK=1024;

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Pass the name of the file in the current directory to be " +
            "zipped as an argument");
           ri System.exit(-1);
        }

        String fileName = args[0];

    }
}
