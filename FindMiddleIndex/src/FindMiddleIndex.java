import java.io.*;
import java.util.*;
import java.lang.*;





/**
 * Created by nazmul on 8/4/14.
 */
public class FindMiddleIndex {

    public static int findMiddleIndex(int[] members) throws Exception {

        int endIndex = members.length - 1;
        int startIndex = 0;
        int sumleft = 0;
        int sumRight = 0;


        while (true) {

            if (sumleft > sumRight) {
                sumRight += members[endIndex--];

            } else {
                sumleft += members[startIndex++];
            }

            if (startIndex > endIndex) {
                if (sumleft == sumRight)
                    break;
                else
                    throw new Exception("Please pass proper array to match the requirement");
            }
        }
        return endIndex+1;
    }

    public static void main(String[] args) throws IOException {
        int [] num = { 2,4,4,5,4,1};
        try {
            System.out.println("Starting from front "+findMiddleIndex(num)+" and ");

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}