package leetcode

/**
 * 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * Created by test
 * Date 2019/7/19 0:59
 * Description
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object  SumOfTwoIntegers {

    class Solution {

        /**
         * 思路:
         * 1. 异或^是不进位加法
         * 2. & 是进位
         */
        fun getSum(a: Int, b: Int): Int {
            if (a == 0) {
                return b
            }

            if ( b == 0) {
                return a
            }

            var nb = b
            var na = a
            while (nb != 0) {
                var tmp = na.xor(nb)
                nb = na.and(nb).shl(1)
                na = tmp
            }
            return na
        }
    }
}