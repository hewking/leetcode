package leetcode

/**35.搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * Created by test
 * Date 2019/5/20 23:41
 * Description
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 */
object SearchInsertPosition{

    class Solution {

        /**
         * 思路:
         * 1.已排序数组，说明是利用二分查找的条件
         * 2.这不就是二分查找吗，然后多加了个条件返回插入位置
         * 也是符合二分查找的啊
         */
        fun searchInsert(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) return 0
            if (target > nums.last() ) {
                return nums.size
            } else if (target < nums.first()) {
                return 0
            }
            var low = 0
            var high = nums.size - 1
            while (low <= high) {
                var m = (low + high).div(2)
                if (nums[m] > target) {
                    high = m - 1
                } else if (nums[m] < target) {
                    low = m + 1
                } else {
                    return m
                }
            }

            return low
        }
    }

}