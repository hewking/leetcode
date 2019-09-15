package leetcode

/**
 * Created by test
 * Date 2019/9/14 17:50
 * Description
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。

如果没有两个连续的 1，返回 0 。



示例 1：

输入：22
输出：2
解释：
22 的二进制是 0b10110 。
在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
第一对连续的 1 中，两个 1 之间的距离为 2 。
第二对连续的 1 中，两个 1 之间的距离为 1 。
答案取两个距离之中最大的，也就是 2 。
示例 2：

输入：5
输出：2
解释：
5 的二进制是 0b101 。
示例 3：

输入：6
输出：1
解释：
6 的二进制是 0b110
 */
object BinaryGap{

    @JvmStatic
    fun main(args: Array<String>) {
//        print("01101".reversed());
        print(Solution().binaryGap(22))
    }

    class Solution {
        fun binaryGap(n: Int): Int {
            val bStr = toB(n)
            println(bStr)
            var maxCoount = 0
            var count = 0
            var last = ' '
            // 01101
            for (i in 0 until bStr.length) {
                if(bStr[i] == '1') {
                    if (last == '1') {
                        maxCoount = Math.max(maxCoount,count)
                        count = 0
                    }
                    maxCoount ++
                }
                count ++
                last = bStr[i]
            }
            return maxCoount- 1
        }

        /**
         * 十进制转二进制
         */
        fun toB(n:Int):String{
            var num = n;
            var s = ""
            while (num > 1) {
                 s += num.rem(2).toString()
                num = num.div(2)
            }
            return s
        }
    }

}