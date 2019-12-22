package leetcode

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * Created by test
 * Date 2019/12/21 14:33
 * Description
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
object WordBreak{

    @JvmStatic
    fun main(args: Array<String>) {
        Solution().wordBreak("abc", emptyList())
    }

    class Solution {

        /**
         * 思路：
         * 初次看了题设，一点思路都没有。感觉好难，拆分字符传
         * 简单先了下暴力的解法，则是获取所有的字符串子串，然后
         * 每一个子串都需要在WordDict 中匹配到值，然后每一次都需要
         * 然后每一个值都需要，这是需要动态规划还是需要其他的算法，
         * 然后没一个分隔符都是不一样的，重复利用这又是一种情况，
         * 要不要还是直接去看答案吧，还是先思考两分钟，毕竟这种情况还是一种
         * 悠闲的情况，特别是处于一种尴尬的情况，还能够特殊处理   并且
         * 还能够使用别的算法去决定，也能够使用其他，然后在能够使用其他的题目
         * 1. 获取字符串s的子串
         */
        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            return backTrack(s, wordDict.toHashSet(),0, BooleanArray(s.length))
        }

        fun backTrack(s:String,wordDict:HashSet<String>,start:Int,memo:BooleanArray): Boolean {
            if (start == s.length) return true
            if(memo[start]) {
                return true
            }
            for (end in start + 1 .. s.length){
                if (wordDict.contains(s.substring(start,end)) && backTrack(s,wordDict,end,memo)) {
                    memo[start] = true
                    return true
                }
            }
            memo[start] = false
            return false
        }

        /**
         * 动态规划版本题解
         */
        fun wordBreak2(s: String, wordDict: List<String>): Boolean {
            val set = wordDict.toSet()
            val dp = BooleanArray(s.length + 1)
            dp[0] = true
            for (i in 1 .. s.length) {
                for (j in 0 until i) {
                    if (dp[j] && set.contains(s.substring(j,i))) {
                        dp[i] = true
                        break
                    }
                }
            }
            return dp[s.length]
        }
    }

}