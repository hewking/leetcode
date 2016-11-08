package leetcode;

/**
 * Created by hewking on 2016/11/8.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 [1,4,4]  s = 4
 the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinSubArrayLen {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(11,nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int min = 0;
        boolean flag = false;
        for(int i = 0 ; i < nums.length - 1 ; i ++){
            for(int j = i + 1; j < nums.length ;j ++){
                int temp = i;
                int sum = 0;
                while( temp <= j){
                    sum += nums[temp];
                    if(nums[i] >= s || nums[j] >= s){
                        return 1;
                    }

                    if(sum >= s){
                        if(!flag){
                            min = j - i + 1;
                            flag = true;
                        }
                        min = Math.min(j - i + 1,min);
//                        System.out.println( j - i + 1);
                    }
                    temp ++;
                }
            }
        }

        return min;
    }
}
