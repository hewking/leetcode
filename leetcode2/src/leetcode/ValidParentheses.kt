package leetcode

import java.util.*

/**
 * 有效的括号 栈相关
 * https://leetcode-cn.com/problems/valid-parentheses/
 * Created by test
 * Date 2019/5/18 15:36
 * Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
class Solution {

    /**
     * 思路：
     * 1.通过栈来解决
     * 2.遇到左括号则入栈
     * 3.遇到右括号则出栈
     * 4.如果不匹配false
     * 5.最终stack不为空false
     */
    fun isValid(s: String): Boolean {
        val p = arrayOf('{','(','[')
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            if (stack.size == 0) {
                stack.push(s[i])
            }  else if (isSymmetric(stack.peek(),s[i])) {
                stack.pop()
            } else {
                stack.push(s[i])
            }

        }
        return stack.isEmpty()
    }

    fun isSymmetric(l : Char ,r : Char) : Boolean {
        return  l == '(' && r == ')' || l == '{' && r == '}' || l == '[' && r == ']'
    }
}

object ValidParentheses{

    @JvmStatic
    fun main(args : Array<String>) {
        Solution().isValid("(])")
    }

}