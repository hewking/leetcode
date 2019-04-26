package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 *
 * 交换律
 *  结合律 a xor (b xor c) == (a xor b) xor c
 *  自反性 a xor b xor b = a xor 0 = a
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-26 10:59
 **/
public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    /**
     * 1. 排序，然后找出前后是否相等如果有则重复了 时间复杂度o(n)
     * 2.
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i ++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

}
