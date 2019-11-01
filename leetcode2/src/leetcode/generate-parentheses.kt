package leetcode

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        **/

object GenerateParentheses {

    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            val ans = mutableListOf<String>()
            generateAll(CharArray(2 * n),0,ans)
            return ans
        }

        fun generateAll(charArr : CharArray,pos: Int,ans: MutableList<String>) {
            if (pos == charArr.size - 1) {
                if (isValid(charArr)) {
                    ans.add(String(charArr))
                }
            } else {
                charArr[pos] = '('
                generateAll(charArr,pos + 1,ans)
                charArr[pos] = ')'
                generateAll(charArr,pos + 1, ans)
            }
        }

        fun isValid(charArr: CharArray) : Boolean{
            var balance = 0
            for (ch in charArr) {
                if (ch == '(') {
                    balance ++
                } else {
                    balance --
                }
                if (balance < 0) {
                    return false
                }
            }
            return balance == 0
        }
    }

}

fun main() {

}