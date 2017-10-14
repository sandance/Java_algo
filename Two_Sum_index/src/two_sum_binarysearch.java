import java.io.IOException;
import java.util.Arrays;

/**
 * Created by NIslam on 9/29/17.
 */
public class two_sum_binarysearch {

        public static boolean twoSum (int [] nums, int target){
            Arrays.sort(nums);

            for(int i =0; i< nums.length ; i++){

                int siblingIndex = Arrays.binarySearch(nums, target - nums[i]);

                if ( siblingIndex >= 0){
                    /*
                    If this points at us, then the pair exist only if there is another copy of the element
                    Look ahead of us and behind us.
                    */
                    if ( siblingIndex != i ||  nums[i - 1] == nums[i]

                            || ( i < nums.length - 1 && nums[i+1] == nums[i]) ){
                            return true;

                    }

                    return false;

                }



            }
            throw new IllegalArgumentException("No Sum");


        }

        public static void main(String[] args) throws IOException {
            Scanner in = new Scanner();

            System.out.println("Enter array elements");

            String[] nums = in.nextLine().split(" ");
            int[] numbers = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                numbers[i] = Integer.valueOf(nums[i]);
            }

            System.out.println("Enter target element: ");
            int target = in.nextInt();

            boolean idxs = twoSum(numbers, target);

            if (idxs==true){
                System.out.println("Solution present");
            }else
                System.out.println("No solution");



        }
}
