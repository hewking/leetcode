package leetcode

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-28 14:11
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

object FindFirstAndLastPositionOfElementInSortedArray {

    class Solution {
        /**
         * 思路：
         * 因为题设要求时间复杂度O(log n) 级别，并且是已排序
         * 数组，所以需要用到二分查找
         * 1. 有可能找到的值处于相同值的中间部分比如 [5，7，7，7，8，10]
         * 二分查找找到的是三个7里面的中间一个，那么需要循环相减
         * 找到first，循环相加找到last
         */
        fun searchRange(nums: IntArray, target: Int): IntArray {
            val index = binarySerach(nums,target)
            if (index < 0) {
                return intArrayOf(-1,-1)
            }
            var first = index
            var last = index
            while (first > 0 && nums[first - 1] == target) {
                first --
            }
            while (last < nums.size - 1 && nums[last + 1] == target) {
                last ++
            }
            return intArrayOf(first,last)
        }

        fun binarySerach(nums:IntArray,target: Int) : Int {
            var low = 0
            var high = nums.size - 1
            while (low <= high) {
                var m = (low + high).div(2)
                when {
                    nums[m] == target -> return m
                    nums[m] < target -> low = m + 1
                    nums[m] > target -> high = m - 1
                }
            }
            return -1
        }
    }

}