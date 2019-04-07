package leetcode

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

https://blog.csdn.net/jerry99s/article/details/46485417 异或的解释，不进位加法，相同为0，不同为1
 交换律
 结合律 a xor (b xor c) == (a xor b) xorc
 自反性 a xor b xor b = a xor 0 = a
 */
object SingleNumber {

    @JvmStatic
    fun main(args : Array<String>) {
        println(singleNumber(intArrayOf(4,1,2,1,2)))
        println(singleNumber(intArrayOf(2,2,1)))
    }

    fun singleNumber(nums: IntArray): Int {
        if (nums.isEmpty()) throw IllegalArgumentException("参数异常")
        var num = 0
        for (n in 0 until nums.size) {
            num = num.xor(nums[n])
        }
        return num
    }

}