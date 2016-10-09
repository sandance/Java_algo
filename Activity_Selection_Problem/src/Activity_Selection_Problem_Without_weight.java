import java.io.*;

/**
 * Created by NIslam on 10/5/16.
 */
public class Activity_Selection_Problem_Without_weight {

    public static void printMaxActivities (int [] s, int [] f, int n){
        int i, j;
        System.out.println("Following activities are selected");

        // First Activity always get selected
        i = 0;
        System.out.print(i+" ");

        // consider rest of the activities
        for(j=1; j < n; j++){
            /*
            If this activity has start time greater than or equal to previously
            selected activity, then select it
             */
            if ( s[j] >= f[i]){
                System.out.print(j+" ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner();

        int n = in.nextInt();
        int [] s = new int [n];
        int [] f = new int [n];

        for(int i=0; i < n;i++){
            s[i] = in.nextInt();
            f[i] = in.nextInt();
        }

        printMaxActivities(s,f,n);

    }

}
