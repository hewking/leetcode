package leetcode

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 171. Excel表列序号
 * Created by test
 * Date 2019/6/16 10:53
 * Description
 * 给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ExcelSheetColumnNumber {
    class Solution {

        /**
         * 思路:
         * 相当于26进制？
         * 是的，26进制转十进制
         */
        fun titleToNumber(s: String): Int {
            var ans = 0
            val sr = s.reversed()
            for (i in 0 until sr.length) {
                ans+= getSortedNum(sr[i]) * Math.pow(26.0,i.toDouble()).toInt()
            }
            return ans
        }

        fun getSortedNum(ch : Char): Int {
            return ch - 'A' + 1
        }
    }
}