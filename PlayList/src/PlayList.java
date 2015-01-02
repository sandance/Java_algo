import java.util.*;

import java.io.IOException;

/**
 * Created by nazmul on 12/15/14.
 */


public class PlayList {

        public static void main(String[] args) throws IOException {
            List<String> playlist = new LinkedList<String>();
            playlist.add("Rock with you -1979");
            playlist.add("Billie Jean - 1983");
            playlist.add("Man In the Mirror - 1988");
            playlist.add("Black Or White - 1991");

            System.out.println("The original playlist of MJ's songs");
            System.out.println(playlist);


            Collections.sort(playlist);
            System.out.println("\nSort the songs by their names ");
            System.out.println(playlist);

            System.out.println("\nIs my most favourite song Black Or White - 1991 present in the list?");
            String backOrWhiteSong = "Black Or White - 1991";
            int index = Collections.binarySearch(playlist,backOrWhiteSong);

            if ( index > 0)
                System.out.printf("Yes, its the %d song \n", (index + 1));
            else
                System.out.printf("No, its not there in the playlist \n");

        }

}
