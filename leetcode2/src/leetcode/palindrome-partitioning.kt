package leetcode

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
["aa","b"],
["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        **/


object PalindromeParitioning {

    class Solution {
        /**
         * 思路： 回溯法
         * 通用框架
         * https://leetcode-cn.com/problems/palindrome-partitioning/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-7/
         * res = []
         * backTrack(路径,选择集) {
         *     if 终止条件
         *         res.add(path)
         *         return
         *     for 选择 in 选择集
         *          选择
         *          backTrack(路径，选择集)
         *          取消选择
         * }
         */
        fun partition(s: String): List<List<String>> {
            val ans = mutableListOf<MutableList<String>>()
            backTrack(ans,s,0, mutableListOf())
            return ans
        }

        /**
         * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
         */
        fun backTrack(res: MutableList<MutableList<String>> ,s:String,index: Int,path: MutableList<String>) {
            if (index == s.length) {
                res.add(path.toMutableList())
                return
            }
            for (i in index  until  s.length) {
                val subStr = s.substring(index,i + 1)
                if (!checkPalindrome(subStr)) {
                    continue
                }
                path.add(subStr)
                backTrack(res,s,i + 1,path)
                path.removeAt(path.size - 1)
            }
        }

        fun checkPalindrome(s: String) : Boolean {
            if (s.length == 1) return true
            val len = s.length
            var flag = true
            for (i in 0 until len / 2) {
                if (s[i] != s[len - 1 - i]) {
                    flag = false
                }
            }
            return flag
        }


    }
    @JvmStatic
    fun main(args: Array<String>) {
        print(Solution().partition("aab"))
    }
}