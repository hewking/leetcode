package leetcode

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * Created by test
 * Date 2020/1/29 20:58
 * Description
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object PerfectSqures {
    class Solution {

        /**
         * 思路:
         * https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
         *  完全平方数 : 1 ,4,9,16,25
         *  n = 12, 4 + 4 + 4 = 12
         *  ...
         *  n = 1 ,2,3,4,5,6,7,8,9
         *  dp = [1,2,3,1,2,3,4,2,1]
         */
        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1)
            for (i in 1 .. n) {
                var j = 1
                dp[i] = i
                while(i - j * j >= 0) {
                    dp[i] = Math.min(dp[i],dp[i - j * j] + 1)
                    j++
                }
            }
            return dp[n]
        }
    }
}