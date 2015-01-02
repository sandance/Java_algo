import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.nio.file.*;

/**
 * Created by nazmul on 12/17/14.
 */
public class BasicFileAttributesExample {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Path path = Paths.get(in.next()); // get the filename

        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(path,BasicFileAttributes.class);
            System.out.println("File size: " + fileAttributes.size());
            System.out.println("isDirectory : "+ fileAttributes.isDirectory());
            System.out.println("issymbolic link : " + fileAttributes.isSymbolicLink());

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
