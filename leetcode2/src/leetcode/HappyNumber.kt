package leetcode

/**
 * 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和
，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例:

输入: 19
输出: true
解释:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
object HappyNumber {

    @JvmStatic
    fun main(args : Array<String>) {
        println(isHappy(19))
    }

     fun isHappy(n: Int): Boolean {
        return happy(n) == 1
    }

    fun happy(n : Int) : Int {
        if (n == 0) return -1
        var result = n
        if (n == 1) {
            result = 1
        } else {
            var sum = 0
            var m = n
            while (m / 10 > 0) {
                sum += Math.pow(n.rem(10).toDouble(),2.0).toInt()
                m /= 10
            }

            result = happy(sum)
        }
        return result
    }
}