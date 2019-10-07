package leetcode

/**
 * 784. 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * Created by test
 * Date 2019/10/7 22:08
 * Description
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object LetterCasePermutation {

    @JvmStatic
    fun main(args: Array<String>) {
        Solution().letterCasePermutation2("a1b2").forEach {
            println(it)
        }
    }

    class Solution {
        fun letterCasePermutation(S: String): List<String> {
            val letters = mutableListOf<String>()


            letter(S, 0, "", letters)


            return letters
        }

        fun letter(s: String, i: Int, target: String, list: MutableList<String>) {
            var res = target
            if (i == s.length) {
                list.add(res)
            }
            if (i > s.length - 1) {
                return
            }
            if (isValid(s[i])) {
                if (isLetter(s[i])) {
                    if (s[i] in 'A'..'Z') {
                        res += s[i] + 32
                        letter(s, i + 1, res, list)
                        letter(s, i + 1, res + s[i], list)
                    } else {
                        res += s[i] - 32
                        letter(s, i + 1, res, list)
                        letter(s, i + 1, res + s[i], list)
                    }
                } else {

                    res += s[i]
                    letter(s, i + 1, res, list)
                }

            }
        }

        fun isValid(s: Char): Boolean {
            return s in '0'..'9' ||
                    s in 'a'..'z' ||
                    s in 'A'..'Z'
        }

        fun isLetter(s: Char): Boolean {
            return s in 'a'..'z' ||
                    s in 'A'..'Z'
        }

        fun letterCasePermutation2(S: String): List<String> {
            val ans = mutableListOf<String>()
            dg(S.toCharArray(), 0, ans)
            return ans;
        }

        fun dg(s: CharArray, i: Int, ans: MutableList<String>) {
            if (i == s.size) {
                ans.add(String(s));
                return;
            }
            dg(s, i + 1, ans);
            if (s[i] < '0' || s[i] > '9') {
                if (s[i] in 'A' .. 'Z') {
                    s[i] = s[i] + 32
                } else {
                    s[i] = s[i] - 32
                }
                dg(s, i + 1, ans);
            }

        }


    }
}