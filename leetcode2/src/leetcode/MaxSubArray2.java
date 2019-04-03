package leetcode;

public class MaxSubArray2 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        for (int i = 0 ; i < nums.length; i ++) {
            for (int j = i ; j < nums.length; j ++) {
                int childSub = 0;
                for (int k = i ; k <= j ; k++) {
                    childSub += nums[k];
                }
                if (maxSub < childSub) {
                    maxSub = childSub;
                }
            }
        }
        return maxSub;
    }

}
