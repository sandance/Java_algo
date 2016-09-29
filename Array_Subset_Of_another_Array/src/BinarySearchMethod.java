/**
 * Created by NIslam on 9/27/16.
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 */

public class BinarySearchMethod {
    /*
     Use sorting and Binary Search
     1) sort array[] O(mlogm)
     2) For each element of array2[] , do binary serch for it in sorted array[]
        if the element is not found then return 0
     3) If all elements are present then return 1
     */
    public static int [] array;
    public static int length;

    public static int binarySearch(int [] arr, int low, int high, int x){
        if ( high >= low){
            int mid = ( low + high ) /2 ;

            if ((mid == 0 || x > arr[mid - 1]) && ( arr[mid] == x))
                return mid;
            else if ( x > arr[mid])
                return binarySearch(arr, (mid + 1), high, x);
            else
                return binarySearch(arr, low, (mid - 1), x);

        }
        return -1;
    }

    public static boolean isSubset( int [] array1, int [] array2, int m, int n){


        QuickSort(array1, 0, m-1);

        for(int i=0; i <n;i++){
              if (binarySearch(array1, 0, m-1, array2[i]) == -1)
                  return false;
          }
          return true;
      }

    public static void exchangeNumbers(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    public static void qsort(int low, int high){
        int lo = low;
        int hg = high;

        int pivot = array[lo+(hg - lo)/2];

        while( lo < hg){
            while( array[lo] < pivot) {
                lo++;
            }
            while ( array[hg] > pivot){
                hg--;
            }

            if ( lo <= hg){
                exchangeNumbers(lo, hg);
                lo++;
                hg--;
            }
        }

        // call qsort() method recursively
        if ( low < hg){
            qsort(low, hg);
        }

        if ( lo < high){
            qsort(lo, high);
        }
    }


    public static  void QuickSort(int [] arr, int si, int ei){

          if(arr == null || arr.length == 0)
              return;

          array = new int [arr.length];
          array = arr;

          length = arr.length;

          qsort(0, length -1);

          for(int i=0; i < length; i++){
              System.out.print(array[i]+ " ");
          }
    }
}
