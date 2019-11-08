package leetcode

import kotlin.math.max

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

        /**
         * 以下为中心拓展算法
         * ***********************************************
         * 思路：
         * 1. 从某个字符作为中心的位置出发
         * 2. 往两边遍历，然后对比是否一致
         * 3. 会有两种情况，中心为一个，比如 aba 或者中心在之间的情况 abba 两种情况
         * 这样就会有 n + n - 1  = 2 * n -1 个中心
         * 4. 找出回文子串最大长度
         * 5. 找出在原始字符串中的位置
         * 6. 获取最长回文子串
         */
        fun longestPalindrome2(s: String): String {
            if (s.isEmpty()) {
                return  s;
            }
            var start = 0
            var end = 0
            for (i in 0 until s.length) {
                var len = this.expandAroundCenter(s,i,i)
                val len2 = this.expandAroundCenter(s,i,i + 1)
                len = max(len, len2)
                if ( len > end - start) {
                    start = i - (len - 1) / 2
                    end = i + len / 2
                }
            }
            return s.substring(start,end)
        }

        /**
         *  获取从中间出发的长度。
         */
        fun expandAroundCenter(s: String, left: Int,right: Int) : Int{
            var L = left
            var R = right
            while (L >= 0 && R < s.length && s[L] == s[R]) {
                L --
                R ++
            }
            return R - L - 1
        }

    }


}

fun main(){
    print(LongestPalindromicSubstring.Solution().longestPalindrome("bb"))
}