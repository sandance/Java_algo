/**
 * Created by NIslam on 10/7/16.
 */

import java.util.ArrayList;

public class activitySelection {
    /* ************* activitySelection() ******************************
     * Use greedy algorithm in selecting activities to maximize the   *
     * number of activities being scheduled 													*
     * ****************************************************************/
    public static ArrayList<Activity> activitySelection(Activity S[]){
        int n = S.length;
        ArrayList<Activity> A = new ArrayList<Activity>(); //new container for maximum number of activities that can be scheduled;
        A.add(S[0]);	// first off,
        // add the acitivity that has the earliest finish time
        // it's part of the greedy algorithm;
        int lastAddedActivityIndex = 0; // in terms of the array S;
        for(int i = 1; i < n; i++){ // O(n);
			/* pick the compatible activity with the earliest finish time */
            if(S[i].startTime >= S[lastAddedActivityIndex].finishTime){
                A.add(S[i]); // add the compatible activity into the new container
                lastAddedActivityIndex = i; // update the last added activity index
            }
        }
        return A;
    } // T(n) = O(n);
}

