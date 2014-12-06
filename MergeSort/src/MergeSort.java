import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.*;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.RuntimeException;
import java.lang.StringBuilder;
import java.lang.System;
import java.util.*;


public class MergeSort {




    private void mergeparts(int low, int mid, int high){


        for(int i=0;i<tempArr.length;i++){
            tempArr[i] = array[i];

        }

        int i = low;
        int j = mid+1;
        int k = low;

        while( i <= mid && j <= high){
            if (tempArr[i] <= tempArr[j]){
                array[k]=tempArr[i];
                i++;

            }else {
                array[k] = tempArr[j];
                j++;

            }
            k++;


        }

        while( i <= mid){

            array[k]= tempArr[i];
            k++;
            i++;
        }



    }

    private void MergeSortUtil(int low, int high){

        if (low < high) {
            int mid = low + (high - low) / 2;
            // Below step sorts the left side of the array
            MergeSortUtil(low, mid);
            // for right side of the array
            MergeSortUtil(mid+1,high);

            mergeparts(low,mid,high);

        }

    }



    public void sort(int [] inputArr, int n){

        this.array = inputArr;
        int length = n;

        tempArr = new int [n];


        MergeSortUtil(0,n-1);



    }




    public int [] array,tempArr;
    public static int n;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        MergeSort ms = new MergeSort();

        System.out.println("Enter number of elements\n");
        n=sc.nextInt();

        int [] inputArr = new int [n];

        for(int i=0;i<n;i++){
            inputArr[i] = sc.nextInt();
        }


        ms.sort(inputArr,n);

        for(int i: inputArr){
            System.out.println(i+" ");
        }


        out.close();

    }




}