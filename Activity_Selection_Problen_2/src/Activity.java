/**
 * Created by NIslam on 10/9/16.
 */



class Activity{
    int activityNr;// the activity number;
    int startTime; // start time of the activity;
    int finishTime;  // end time of the activity;
    public Activity(int aNr, int s, int f){
        activityNr = aNr;
        startTime = s;
        finishTime = f;
    }
    public String toString(){
        return ( activityNr + "		" + startTime + "		" + finishTime);
    }
}