import java.util.Scanner;
import java.io.IOException;
/**
 * Created by NIslam on 10/16/16.
 */
public class min_number_of_coins_given_change  {

    public static int minCoins(int [] coins, int n, int V){
        int result=Integer.MAX_VALUE;

        if (V==0) return 0;

        // Try every coin which has a smaller value than V
        for(int i=0; i < n; i++){
            if ( coins[i] <= V  ) {

                int sub_res = minCoins(coins, n, V - coins[i]);

                // check for INT_MAX to avoid overflow

                if  (sub_res != Integer.MAX_VALUE && sub_res + 1 < result){
                    result = sub_res + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the standard coins");
        int  n = in.nextInt();
        System.out.println("Enter change amount");

        int V = in.nextInt();

        int [] coins = new int [n];

        for(int i=0; i < n;i++)
            coins[i] = in.nextInt();

        int result = minCoins(coins,n,V);

        System.out.println("Minimum coins: "+ result);


    }

}
