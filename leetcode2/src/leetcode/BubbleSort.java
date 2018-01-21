package leetcode;

import java.util.Arrays;

/**
 * Created by hewking on 2016/11/7.
 */

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = new int[]{3,26,42,75,34,65,23};
        sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr){

        for(int i = 0 ; i < arr.length ;i ++){
            for(int j = 0; j < arr.length - 1 - i ; j ++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }


        return arr;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
