package leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * 时间复杂度o(N)解法
     * 取数组第一个元素，count=1.遇到相同加1不同减1
     * 到0就换一个数开始
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int value = nums[0];
        int count = 1;
        for (int num : nums) {
            if (num != value) {
                count --;
                if (count == 0) {
                    count = 1;
                    value = num;
                }
            } else {
                count ++;
            }
        }
        return value;
    }

}
