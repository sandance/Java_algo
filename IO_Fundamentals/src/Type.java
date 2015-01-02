import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nazmul on 12/23/14.
 */
public class Type {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
                System.err.println("pass the name of the file as argument");
                System.exit(-1);
        }


    // process each file passed as argument
    for(String file: args){
        // try opening the file with filereader
        try{
            FileReader inputFile = new FileReader(file);
            int ch = 0;
            while ( (ch = inputFile.read()) != -1) {
                // ch is of type int - convert it back to char
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException fx){
            System.out.printf("Cannot open the given file %s" , file);
            fx.printStackTrace();
        }
    }

    }
}