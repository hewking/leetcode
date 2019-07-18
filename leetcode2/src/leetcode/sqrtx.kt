package leetcode

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * Created by test
 * Date 2019/7/18 0:50
 * Description
 * 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Sqrt {

    @JvmStatic
    fun main(args: Array<String>) {
       println(Solution().mySqrt(2147483647))
    }

    class Solution {

        /**
         * 思路：
         * 理论上可行这种方式，可是相乘会导致结果超出Int上限，导致错误
         */
        fun mySqrt(x: Int): Int {
            for (i in 1 until (x + 1)) {
                if (i * i == x) {
                    return i
                } else if (i * i > x) {
                    return i - 1
                }
            }
            return 0
        }

        /**
         * 思路:
         * 1. 通过二分查找思想，找出中间数，然后平方
         * 2.根据平方结果与x值进行比较
         */
        fun mySqrt2(x: Int): Int {
            if ( x < 2) {
                return x
            }
            return sqrt(x,0,x)
        }

        fun sqrt(x: Int,low: Int,high: Int): Int{
            if (low > high) {
                return high
            }
            var m = (low + high) / 2
            if (m > x / m) {
                return sqrt(x,low , m - 1)
            } else if (m < x / m) {
                return sqrt(x,m + 1 , high)
            } else {
                return m
            }
        }

        }
}