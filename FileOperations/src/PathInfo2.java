import java.nio.file.*;
import java.io.IOException;

/**
 * Created by nazmul on 12/17/14.
 */
public class PathInfo2 {
    public static void main(String[] args) throws IOException {
        // Get a path object with relative Pathe
        Path testFilePath = Paths.get("home_location_one_subscriber.txt");

        System.out.println("The file name is : "+testFilePath.getFileName());
        System.out.println("Its URI is: "+testFilePath.toUri());
        System.out.println("Its absolute path is "+testFilePath.toAbsolutePath());
        System.out.println("Its normalized path is : "+testFilePath.normalize());

        // Get another path object with normalized relative path
        Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
        System.out.println("Its normalized absolute path is: "+ testPathNormalized.toAbsolutePath());


    }
}
