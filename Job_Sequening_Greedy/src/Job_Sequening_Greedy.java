import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Created by NIslam on 10/16/16.
 */
public class Job_Sequening_Greedy {

    public static void printJobScheduling(List<Job> jobList, int n){
        // To store results (Sequence of Jobs)
        char [] result = new char [n];
        // To keep track of free time slots
        boolean [] slot = new boolean[n];

        // Initialize all slots to be free
        Arrays.fill(slot, false);

        // Iterate through all given jobs

        for(int i=0; i <n; i++) {
            /*
            Find a free slot for this job
             */
            for(int j = Math.min(n, jobList.get(i).getDeadline()) - 1; j >= 0; j--){

                // Free Slot found
                System.out.println("Processing "+ jobList.get(i).id);

                if ( slot[j] == false){
                    System.out.println("Setting slot "+j+" for Job  "+jobList.get(i).id);
                    result[j] = jobList.get(i).id; // Add this job to result
                    slot[j] = true; // Make this slot occupied
                    break;
                }
            }
        }

        // print the results

        for(int i=0; i <n; i++){
            if (slot[i] == true){
                System.out.println(result[i]);
            }
        }





    }

    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter total number of jobs");

        int n  = in.nextInt();

        List<Job> jobList = new ArrayList<Job> ();

        for(int i=0; i < n;i++){
            char name = in.next().charAt(0);
            int dead = in.nextInt();
            int profit = in.nextInt();

            Job newJob = new Job(name, dead, profit);
            jobList.add(newJob);
        }

        Collections.sort(jobList, Collections.reverseOrder());
        System.out.println("After Sorting.....");

        for(int i=0; i < jobList.size(); i++){
            System.out.println(jobList.get(i).id+" "+jobList.get(i).getDeadline() +" "+jobList.get(i).getProfit());
        }

        printJobScheduling(jobList, n);



    }
}
