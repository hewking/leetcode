package leetcode

/**
 *50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-15 15:34
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object PowxN {

    class Solution {
        fun myPow(x: Double, n: Int): Double {
            var calcResult = 1.0
            if (x == 0.0) return 0.0
            if (x == 1.0) return 1.0
            if (n < 0) {
                val x1 = x

            }
            for (i in 0 until Math.abs(n)) {
                calcResult *= x
            }
            return if (n < 0) {
                 1 / calcResult
            } else {
                  calcResult
            }
        }
    }

}