package leetcode

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * Created by test
 * Date 2020/1/31 0:02
 * Description
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object DecodeWays {
    class Solution {

        /**
         * 思路: 动态规划
         * https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
         */
        fun numDecodings(s: String): Int {
            val len = s.length
            val dp = IntArray(len + 1)
            dp[len] = 1
            if (s[len - 1] != '0') {
                dp[len - 1] = 1
            }
            for (i in len -1 downTo 0) {
                if (s[i] == '0') {
                    continue
                }
                val ans1 = dp[i + 1]
                var ans2 = 0
                val ten = (s[i] - '0') * 10
                val one = s[i + 1] - '0'
                if (ten + one <= 26) {
                    ans2 = dp[i + 2]
                }
                dp[i] = ans1 + ans2
            }
            return dp[0]
        }
    }
}