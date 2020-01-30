/**
 * 152. 乘积最大子序列
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

object MaximumProductSubarray {
    class Solution {

        var res = 0
        /**
         * 思路：回溯法 最简单暴力解答,超出时间限制
         */
        fun maxProduct_(nums: IntArray): Int {
            res = nums.reduce({ pre, cur ->
                Math.min(pre, cur)
            })
            backTrack(nums, 0)
            return res
        }

        fun backTrack(nums: IntArray, start: Int) {
            if (start >= nums.size) {
                return
            }
            for (i in start until nums.size) {
                val subArr = nums.copyOfRange(start, i + 1)
                val minusRes = minusInArray(subArr)
                res = Math.max(res, minusRes)
                backTrack(nums, i + 1)
            }
        }

        /**
         * 获取数组的乘积
         */
        fun minusInArray(nums: IntArray): Int {
            return nums.reduce { acc, i ->
                acc * i
            }
        }

        /**
         * https://leetcode-cn.com/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/
         */
        fun maxProduct(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            val n = nums.size
            val dpMax = IntArray(n)
            dpMax[0] = nums[0]
            val dpMin = IntArray(n)
            dpMin[0] = nums[0]
            var max = nums[0]
            for (i in 1 until n) {
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i] , Math.max(dpMax[i - 1] * nums[i],nums[i]))
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i] ,Math.min(dpMax[i - 1] * nums[1] ,nums[i]))
                max = Math.max(max,dpMax[i])

            }
            return max
        }
    }
}
