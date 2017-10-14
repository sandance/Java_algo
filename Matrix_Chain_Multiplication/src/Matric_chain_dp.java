import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * Created by NIslam on 10/7/17.
 */
public class Matric_chain_dp {

    public static void printArr(int [][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                System.out.print(p[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int MatrixChainDP(int [] p, int n){

        int [][] dp = new int [n][n];

        int i, j , k, L, q;

        // cost is zore when multiplying one matric
        for(i=0; i < n;i++)
            dp[i][i] = 0;

        printArr(dp);

        // L is chain length
        for(L=2; L < n; L++){
            for(i = 1; i < n-L+1; i++){

                j = i + L - 1;
                if (j == n)
                    continue;

                dp[i][j] = Integer.MAX_VALUE;

                for(k=i; k <= j - 1; k++){
                    // cost

                    q = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];

                    System.out.println("i: "+i+"k: "+k+" j"+j+" cost: "+q);

                    if ( q < dp[i][j])
                        dp[i][j] = q;
                }
            }
            System.out.println("Length of Arr: "+L);
            printArr(dp);
        }

        return dp[1][n-1];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner ();

        System.out.println("Size of the array");
        int n = in.nextInt();

        int [] arr = new int[n];
        for(int i=0; i < n;i++){
            arr[i] = in.nextInt();
        }

        int minNum = MatrixChainDP(arr,arr.length);

        System.out.println("Minimum number of Multiplicaitons in DP: "+ minNum);

    }
}
