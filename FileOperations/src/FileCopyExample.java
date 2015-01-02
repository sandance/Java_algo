import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.nio.file.*;


/**
 * Created by nazmul on 12/17/14.
 */
public class FileCopyExample {
    public static void main(String[]  args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String inputPath = in.next();
        out.println("Enter destination path\n");
        String outPath = in.next();

        Path pathSource = Paths.get(inputPath);
        Path pathDestination = Paths.get(outPath);

        try {
                Files.copy(pathSource,pathDestination);
                System.out.println("Source file copied successfully");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
