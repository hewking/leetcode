package leetcode

import java.lang.IllegalArgumentException

/**
 * https://leetcode-cn.com/problems/missing-number/
 * 268. 缺失数字
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-18 19:26
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

object MissingNumber {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    class Solution {
        /**
         * 思路：
         * 题设区间是 [0,n]
         * 先排序，n 为自然数集合。 首位数是0
         * 然后判断两个数相差是否为1
         */
        fun missingNumber(nums: IntArray): Int {
            if (nums.isEmpty()) {
                throw IllegalArgumentException()
            }
            nums.sort()

            if (nums[0] != 0) {
                return 0
            }
            for (i in 1 until nums.size) {
                if (nums[i] - nums[i - 1] != 1) {
                    return nums[i] - 1
                }
            }
            return nums.last() + 1
        }
    }

}