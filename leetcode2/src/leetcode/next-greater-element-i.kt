package leetcode

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * Created by test
 * Date 2019/10/7 22:56
 * Description
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
注意:

nums1和nums2中所有元素是唯一的。
nums1和nums2 的数组大小都不超过1000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object NextGreaterElementI {

    @JvmStatic
    fun main(args : Array<String>) {
        Solution().nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2))
    }

    class Solution {
        /**
         * 思路：
         * 1. 原题是用栈的，但是我不会，现在这种方式更简单，只是时间复杂度O(n^2)
         * 2. 通过遍历nums1 ,并且都在nums2 中，然后通过 nums2.indexOf 获取 相对应的在
         * nums2 中位置，然后从该位置遍历到nums2 最后。找到大于nums1 中值的元素，没有则赋值为-1
         */
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val ans = IntArray(nums1.size)
            nums1.forEachIndexed { index, i ->
                val k = nums2.indexOf(i)
                for (j in k + 1 .. nums2.size) {
                    if (j < nums2.size) {
                        if (i > nums2[j]) {
                            ans[index] = -1
                        } else {
                            ans[index] = nums2[j]
                            break
                        }
                    } else {
                        ans[index] = -1
                    }
                }
            }
            return ans
        }
    }

}