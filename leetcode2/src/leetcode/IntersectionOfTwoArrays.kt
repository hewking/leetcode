package leetcode

import java.util.*

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * Created by test
 * Date 2019/5/20 23:28
 * Description
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */

object IntersectionOfTwoArrays{

    class Solution {
        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            Arrays.sort(nums1)
            Arrays.sort(nums2)

            val minArr = if (nums1.size > nums2.size) nums2 else nums1
            val maxArr = if (nums1.size > nums2.size) nums1 else nums2

            val arrList = mutableSetOf<Int>()
            for (num in minArr) {
                for (num2 in maxArr) {
                    if (num == num2) {
                        arrList.add(num)
                        continue
                    }
                }
            }

            return arrList.toIntArray()
        }
    }

}
