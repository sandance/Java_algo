import java.util.Comparator;
/**
 * Created by NIslam on 10/7/16.
 */
public class ActivityComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2){
        return a1.getFinishTime() - a2.getFinishTime();
    }
}
