import java.util.ArrayList;
import java.util.*;
import java.io.*;


/**
 * Created by NIslam on 10/7/16.
 */
public class Activity_Selection_Problem_with_weight {
    private static List<Activity>  activityList = new ArrayList<Activity>();

    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner();
        System.out.println("Enter number of Activities");
        int n = sc.nextInt();

        for(int i=0; i < n;i++){
            int srt = sc.nextInt();
            int finish = sc.nextInt();
            int profit = sc.nextInt();

            activityList.add(new Activity(srt, finish, profit));
        }

        Collections.sort(activityList, new ActivityComparator());

        for(int i=0; i < activityList.size();i++)
            System.out.println(activityList.get(i).getStartTime() +" "+activityList.get(i).getFinishTime());


        int i=0;
        System.out.print(i+" ");


        for(int j=1; j < activityList.size(); j++){
            if (activityList.get(j).getStartTime() > activityList.get(i).getFinishTime()){
                System.out.print(j+" ");
                i = j;
            }
        }

    }


}
