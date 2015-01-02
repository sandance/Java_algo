import java.io.*;
import java.util.Scanner;


/**
 * Created by nazmul on 12/23/14.
 */
public class FileReaderFromInput {
    public static void main(String[] args) throws IOException {
        Scanner user = new Scanner(System.in);
        String inputFileName,outputFileName;

        // Take the input file from I/O
        System.out.println("Input file Name");
        inputFileName = user.nextLine().trim();
        outputFileName = user.nextLine().trim();


        BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFileName));

        int ch =1;
        while(ch) {
            ch = inputFile.read();

            if (ch != -1) {

                outputFile.write((char) ch);
            }
        }


    }

}
