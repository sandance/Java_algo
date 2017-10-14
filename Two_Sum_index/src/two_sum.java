import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;

/**
 * Created by NIslam on 9/29/17.
 */
public class two_sum {

    public static int [] twoSum (int [] nums, int target){
        HashMap <Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i=0; i < nums.length; i++){
            numMap.put(nums[i], i);
        }


        for (int i =0; i <= nums.length; i++){
            int reminder = target - nums[i];

            if (numMap.containsKey(reminder) && numMap.get(reminder) != i){
                return new int [] { i, numMap.get(reminder) };
            }
        }
        throw new IllegalArgumentException("No two sum");


    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();

        System.out.println("Enter array elements");

        String [] nums = in.nextLine().split(" ");
        int [] numbers = new int [nums.length];

        for (int i=0; i< nums.length; i++){
            numbers[i] = Integer.valueOf(nums[i]);
        }

        System.out.println("Enter target element: ");
        int target = in.nextInt();

        int [] idxs = twoSum(numbers, target);

        for(int i=0; i < idxs.length; i++){
            System.out.print(idxs[i]+" ");
        }

    }
}
