package leetcode

/**
 * @Classname closestDivisors
 * @Description TODO
 * @Date 2020-05-16 13:47
 * @Created by jianhao
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：

两数乘积等于  num + 1 或 num + 2
以绝对差进行度量，两数大小最接近
你可以按任意顺序返回这两个整数。



示例 1：

输入：num = 8
输出：[3,3]
解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
示例 2：

输入：num = 123
输出：[5,25]
示例 3：

输入：num = 999
输出：[40,25]
 */
object ClosestDivisors {
    class Solution {
        fun closestDivisors(num: Int): IntArray {
            val first = num + 1
            val second = num + 2
            // 1. 如果从num 开根号开始，如果根号9 == 3 ，那么两个数就最近
            // 但是不是自然数，不符合需求
            val a_ = findMinDistance(first);
            val b_ = findMinDistance(second)
            return if (a_[0] - a_[1] > b_[0] - b_[1]) {
                b_
            } else a_
        }

        fun findMinDistance(num:Int): IntArray {
            var a = Math.sqrt(num.toDouble())
            var a_ = a.toInt()
            for (i in a_ downTo 0) {
                val b = num.div(a_)
                if (b * a_ == num) {
                    return intArrayOf(a_,b)
                }
            }
            return intArrayOf(-1,Int.MAX_VALUE)
        }


    }
}
