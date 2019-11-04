package leetcode

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-26 13:39
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

典型题： 动态规划
题解：
https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
 **/

object LongestPalindromicSubstring {
    class Solution {

        /**
         * 思路：
         * 暴力法
         * 典型动态规划题
         */
        fun longestPalindrome(s: String): String {
            var ans = ""
            if (s.length == 1) {
                return s
            }
            for (i in s.indices) {
                for (j in i until s.length) {
                    for (k in i .. j) {
                        val subStr = s.substring(i,k + 1)
                        if (isPalindromeStr(subStr)) {
                            ans = if (subStr.length > ans.length) subStr else ans
                        }
                    }
                }
            }
            return ans
        }

        fun isPalindromeStr (str: String) : Boolean {
            var i = 0
            var j = str.length - 1
            while (i <= j) {
                if (str[i] != str[j]) {
                    return false
                }
                i ++
                j --
            }
            return true
        }
    }


}

fun main(){
    print(LongestPalindromicSubstring.Solution().longestPalindrome("bb"))
}