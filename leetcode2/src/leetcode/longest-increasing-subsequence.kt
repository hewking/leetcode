package leetcode

import kotlin.math.max

/**
 * 300. 最长上升子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

object LongestIncreasingSubsequence {

    class Solution {

        /**
         * 思路：
         * 采用回溯法， 最大，则需要包括Max
         * 回溯法通用框架
         * res = []
         * backTrack(路径，选择集) {
         *  if 终止条件
         *      res.add(path)
         *      return
         *   for 选择 in 选择集 {
         *      选择
         *      backTrack(路径，选择集)
         *      撤销选择
         *   }
         * }
         */

        var max = 0

        /**
         * 回溯方式得到的是最长字串，而不是最长子序列
         */
        fun lengthOfLISubstr(nums: IntArray): Int {
            backTrack(nums,0)
            return max
        }

        fun backTrack(nums: IntArray,index: Int) {
            if (index > nums.size) {
                return
            }
            for (i in index until nums.size) {
                val rangeNums = nums.copyOfRange(index,i + 1)
                if (!checkLIS(rangeNums)) {
                    continue
                }
                max = max(max, rangeNums.size)
                backTrack(nums,i + 1)
            }
        }

        fun checkLIS(nums: IntArray) : Boolean {
            if (nums.size == 1) {
                return true
            }
            for (i in 1 until nums.size) {
                if (nums[i] < nums[i - 1]) {
                    return false
                }
            }
            return true
        }

        /**
         * 思路:
         * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-she-ji-fang-fa-zhi-pai-you-xi-jia/
         * 动态规划
         *
         */
        fun lengthOfLIS(nums: IntArray): Int {
            if (nums.size == 1) {
                return 1
            }
            // dp[i] 为nums数组中到 nums[i] 为止的最长子序列
            val dp = IntArray(nums.size)
            // dp 数组子序列，最短需要包含自身，所以长度至少1
            dp.fill(1)
            for (i in 0 until nums.size) {
               for (j in 0 until i) {
                   if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i],dp[j] + 1)
                   }
               }
            }
            // dp 数组中的最大值，为LIS
            return dp.reduce { acc, i ->
                Math.max(acc,i)
            }
        }

    }
    @JvmStatic
    fun main(args: Array<String>) {
        print(Solution().lengthOfLIS(intArrayOf(10,67,11,12,8)))
    }
}