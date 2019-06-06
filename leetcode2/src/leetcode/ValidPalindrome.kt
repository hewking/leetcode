package leetcode

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * Created by test
 * Date 2019/6/7 0:45
 * Description
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ValidPalindrome {

    @JvmStatic
    fun main(args : Array<String>) {
//        Solution().isPalindrome("A man, a plan, a canal: Panama")
//        println(Solution().isPalindrome(".a"))
        println(Solution().isPalindrome("0P"))
    }

    class Solution {
        fun isPalindrome(s: String): Boolean {
            if (s.isEmpty()) return true
            var l = 0
            var r = s.length - 1
            while (l in 0..(r - 1)) {
                while (l in 0..(r - 1) && !valid(s[l])) {
                    l ++
                }

                while (l in 0..(r - 1) && !valid(s[r])) {
                    r --
                }

                if (s[l].toUpperCase() != s[r].toUpperCase()) {
                    return false
                }
                l++
                r--
            }
            return true
        }

        fun valid(ch : Char) : Boolean{
            return ch in 'a'..'z' || ch in 'A'..'Z' || ch in '0' .. '9'
        }

    }

}