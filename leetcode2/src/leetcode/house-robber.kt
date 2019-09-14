package leetcode

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * Created by test
 * Date 2019/9/14 16:09
 * Description
 * 系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
object HouseRobber {

    @JvmStatic
    fun main(args: Array<String>) {
        val sum = Solution().rob(arrayOf(2,7,9,3,1).toIntArray())
        print(sum)
    }

    /**
     * 思路：
     * 动态规划问题，重要的是找到状态转移公式
     * 1. 设 f(n) 为n个房子的最大金额，An 为第n个房子的最大金额
     * 2. n = 1 : f(1) = A1
     * 3. n = 2 : f(2) = Max(A1 + A2)
     * 4. n = 3 : f(3) = Max(f(1) + A3,f(2))
     * 5. f(0) = 0
     * 6. 公式：f(n) = Max(f(n-2) + An ,f(n-1))
     */
    class Solution {
        fun rob(nums: IntArray): Int {
            var prevSum = 0
            var currSum = 0
            for (i in nums.indices) {
                val tmp = currSum
                currSum = Math.max(prevSum + nums[i],currSum)
                prevSum = tmp
            }
            return currSum
        }
    }

}