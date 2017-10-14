import java.io.IOException;

/**
 * Created by NIslam on 10/3/17.
 */
public class matrix_chain_recursion {

    public static int MatrixChainRecursive(int [] arr, int i, int j) {
        /*
        Base case:
        */


        if (i==j) return 0;

        int min = Integer.MAX_VALUE;

        for(int k=i;k < j; k++){

            System.out.println("Array values : i: "+ i +" K: "+ k +" J: "+j+" Array[i-1]" +arr[i-1]+" Array[k]: "+
            arr[k]+ " Array[j]: "+arr[j]);

            int count = MatrixChainRecursive(arr,i,k) +
                    MatrixChainRecursive(arr, k+1 ,j) +
                    arr[i - 1] * arr[k] * arr[j];

            System.out.println(" Count: "+ count);

            if (count < min)
                min = count;
        }

        return min;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner ();

        System.out.println("Size of the array");
        int n = in.nextInt();

        int [] arr = new int[n];
        for(int i=0; i < n;i++){
            arr[i] = in.nextInt();
        }

        int minNum = MatrixChainRecursive(arr,1,n - 1);

        System.out.println("Minimum number of Multiplicaitons: "+ minNum);

    }
}
