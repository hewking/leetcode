package leetcode

/**
 * 461. 汉明距离
 * Created by test
 * Date 2019/5/30 1:26
 * Description
 * https://leetcode-cn.com/problems/hamming-distance/
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
↑   ↑

上面的箭头指出了对应二进制位不同的位置。
 */
object HammingDistance {

    @JvmStatic
    fun main(args : Array<String>) {
        val s = Solution()
//        print(s.toB(5))
        s.hammingDistance(1,4)
    }

    class Solution {

        /**
         * 思路:
         * 1.先进行异或操作，所得结果中的1的个数即为所得
         * 2.统计1的个数，通过mod 2 如果为0则是二进制结果中的1
         * 3.循环往复
         */
        fun hammingDistance2(x : Int,y : Int) : Int {
            var r = x.xor(y)
            var count = 0
            while (r > 0) {
                count += r.rem(2)
                r = r.shr(1)
            }
            return count
        }

        /**
         * 土办法，先计算整数的二进制，然后累加不同的数的个数
         */
        fun hammingDistance(x: Int, y: Int): Int {
            val s1 = toB(x)
            val s2 = toB(y)

            var count = 0

            val s = if (s1.length > s2.length) s1 else s2
            val s3 = if (s1.length > s2.length) s2 else s1
            for (i in s.indices) {
                if (i < s.length - s3.length) {
                    if (s[i] != '0') {
                        count ++
                    }

                } else {
                    if (s[i] != s3[i - (s.length -s3.length)]) {
                        count ++
                    }
                }
            }

            return count

        }

        fun toB(n : Int) : String{
            val sb = StringBuffer()
            var x = n
            while (x > 0) {
                sb.append(x.rem(2))
                x /= 2
            }
            return sb.toString().reversed()
        }
    }
}