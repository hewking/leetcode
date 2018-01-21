package leetcode;

import java.util.Arrays;

/**
 * Created by hewking on 2016/11/7.
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */

public class TwoSum {

    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i + 1; j < nums.length ;j++){
                if(target == nums[j] + nums[i]){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

}
