package leetcode

import java.util.*

/**448. 找到所有数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * Created by test
 * Date 2019/7/17 0:56
 * Description
 *给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

排序后：
[1,2,2,3,3,4,7,8]
输出:
[5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object FindAllNumbersDisappearedInAnArray {

    @JvmStatic
    fun main(args:Array<String>) {

    }

    class Solution {
        fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val result = mutableListOf<Int>()
            Arrays.sort(nums)
            for (i in 1..nums.size) {
                if (Arrays.binarySearch(nums, i) < 0) {
                    result.add(i)
                }
            }
            return result
        }

        /**
         * 思路：
         * 置所有数组正整数值为下标，把所有值作为下标的值设
         * 为负数，
         */
        fun findDisappearedNumbers3(nums: IntArray): List<Int> {
            val result = mutableListOf<Int>()
            for (i in 0 until nums.size) {
                var index = Math.abs(nums[i]) -1
                nums[index] = - Math.abs(nums[index])
            }
            for (i in 0 until nums.size) {
                if (nums[i] > 0) {
                    result.add(i + 1)
                }
            }
            return result
        }

//        fun findDisappearedNumbers2(nums: IntArray): List<Int> {
//            val result = mutableListOf<Int>()
//            Arrays.sort(nums)
//            var curIndex = 0
//            for (i in 1..nums.size) {
//                if (i == nums[curIndex]) {
//                    curIndex++
//                    continue
//                } else if (i > nums[curIndex]) {
//                    while (i > nums[curIndex]) {
//                        curIndex++
//                    }
//                } else if (i < nums[curIndex]) {
//                    result.add(nums[i - 1])
//                }
//            }
//            return result
//        }
    }
}