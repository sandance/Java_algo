/**
 * Created by NIslam on 10/16/16.
 */
public class Job implements Comparable<Job> {
    public char id; // Job id
    public int deadline; // deadline of job
    public int profit; // Profit if job is over before or on deadline

    Job(char id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getDeadline(){
        return deadline;
    }

    public int getProfit() {
        return profit;
    }

    public int compareTo(Job job){
        return this.profit - job.profit;
    }

}
