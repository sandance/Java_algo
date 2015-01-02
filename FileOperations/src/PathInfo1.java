
import java.io.IOException;
import java.nio.file.*;


/**
 * Created by nazmul on 12/17/14.
 */
public class PathInfo1 {
    public static void main(String[] args) throws IOException {

        // create a path object by calling static method get() in Paths class
        Path testFilePath = Paths.get("/home/nazmul/home_location_one_subscriber.txt");

        // retrieve basic information about Path
        System.out.println("Printing file information...");
        System.out.println("\t file name : " + testFilePath.getFileName());
        System.out.println("\t root of the path : "+testFilePath.getRoot());
        System.out.println("\t parent of the target : "+ testFilePath.getParent());
        System.out.println("\t total number of elements : "+testFilePath.getNameCount());

        // print path elements

        for (Path element : testFilePath)
            System.out.println("\t Path element: "+element);
    }
}
