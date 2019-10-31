package leetcode
/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        **/

object FirstUniqueCharInAString {

    class Solution {
        /**
         * 思路：
         * 1. 遍历字符串找到每个char
         * 2. 运用位运算 ： 任何数与1异或两次返回 等于原数
         */
        fun firstUniqChar(s: String): Int {
            if (s.length == 1) {
                return 0
            }
            var unselected = BooleanArray(s.length)
            for (i in 0 until s.length) {
                if (unselected[i]) {
                    continue
                }
                for (j in i + 1 until s.length) {
                    if (s[i] == s[j]) {
                        unselected[j] = true
                        unselected[i] = true
                    }
                }
                if (unselected[i]){
                    continue
                }
                return i
            }
            return unselected.indexOfFirst {
                !it
            }
        }
    }

}

fun main() {
    print(FirstUniqueCharInAString.Solution().firstUniqChar("cc"))
}