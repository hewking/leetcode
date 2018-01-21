package leetcode;

/**
 * Created by Administrator on 2016/11/14.
 * <p>
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class JumpGame {

    public static void main(String[] args){
        int[] input = {2,5,0,0};
        System.out.println(canJump(input) + ":::" + isLast);
    }

    private static boolean isLast = false;

    public static boolean canJump(int[] nums) {

        boolean boo = jump(nums,0);
        return boo;
    }

    private static boolean jump(int[] nums, int i) {
        int jumpIndex = nums[i];
        boolean canjump = false;
        if(i + jumpIndex >= nums.length - 1){
            isLast = true;
            return true;
        }
        for(int k = 1; k <= jumpIndex; k++ ){
            if(i + k >= 0){
                canjump = jump(nums,i + k);
//                isLast = true;
            }
        }
        return canjump;
    }
}
