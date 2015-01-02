import java.io.*;
import java.util.*;

public class Insertion_Sort {

    static int[] inputArr;


    public static void insertion_sort(int[] inputArr) {
        for ( int i = 1,j; i < inputArr.length; i++) {
            int temp = inputArr[i];
            for ( j = i; j > 0 && temp < inputArr[j - 1]; j--) {
                inputArr[j] = inputArr[j - 1];
            }
            inputArr[j] = temp;


        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);


        int n = in.nextInt();

        inputArr = new int[n];

        for (int i = 0; i < n; i++)
            inputArr[i] = in.nextInt();

        // filled the array

        insertion_sort(inputArr);

        for (int i = 0; i < n; i++)
            System.out.println(inputArr[i] + " ");

    }
}