import sun.awt.image.ImageWatched;
import java.util.*;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by nazmul on 12/17/14.
 */
public class FileAttributes {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String filename = in.next();
        Path path = Paths.get(filename);

        try {
            Object object = Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS);
            System.out.println("Creation time" + object);

            object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
            System.out.println("Last modified time: " + object );

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
