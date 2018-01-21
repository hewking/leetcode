package leetcode.sort;

import java.util.Arrays;

/**
 * Created by hewking on 2017/3/25.
 */

public class QuickSort {

    public static void main(String[] args){
        int[] arr = new int[]{3,26,42,75,34,65,23};
        quickSort(arr,0,arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int start , int end) {
        if (start > end) {
            return;
        }
        int part = part(arr,start, end);
        quickSort(arr,start,part - 1);
        quickSort(arr,part + 1 , end);
    }

    public static int part(int[] arr , int i , int j) {
        int value = arr[i];
        while (i < j) {


            while (i < j && arr[j] >= value){
                j--;
            }
            arr[i] = arr[j];

            while (i < j && arr[i] <= value){
                i++;
            }

            arr[j] = arr[i];

//            swap(arr,i,j);

        }
        arr[i] = value;
        return i;
    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
