package leetcode.sort;

import java.util.Arrays;

/**
 * Created by hewking on 2016/11/7.
 */

public class BubbleSort implements SortStrategy{

    public static void main(String[] args){
        Integer[] arr = new Integer[]{3,26,23,42,75,34,65,23};
        sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static Integer[] sort(Integer[] arr){

        for(int i = 0 ; i < arr.length-1 ;i ++){
            for(int j = 0; j < arr.length - 1 - i ; j ++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }


        return arr;
    }

    public static <T> void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public <T> T[] sort(T[] t) {
        return null;
    }
}
