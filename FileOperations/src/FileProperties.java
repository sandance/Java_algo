import java.io.IOException;
import java.nio.file.*;


/**
 * Created by nazmul on 12/17/14.
 */
public class FileProperties {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("/home/nazmul/home_location_20140915.png");
        Path path2 = Paths.get("/home/nazmul/home_location_one_subscriber.txt");

        if(Files.exists((path1) , LinkOption.NOFOLLOW_LINKS)){
            System.out.println("The file/ directory "+path1.getFileName() +"exists");
        } else
            System.out.println("The file/directory " + path1.getFileName() + " does not exist");


        System.out.println("Files.isSameFile(path1,path2) is : " + Files.isSameFile(path1,path2));


        // Existing files might not allow you to read, write, eexcute based on the credentials . You can check
        // ability of a program to read, write or execute

        System.out.printf("Readable : %b, Writable : %b, Executable: %b" , Files.isReadable(path1) , Files.isWritable(path1) , Files.isExecutable(path1));
    }
}
