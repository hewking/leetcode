package leetcode

import java.util.*

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * Created by test
 * Date 2019/5/23 0:51
 * Description
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
object IntersectionOfTwoArraysII{

    class Solution {
        /**
         * 思路：
         * 1.因为不需要要求不重复，所以list集合
         * 2.因为是排好序的，所以下一轮排序 start = i + 1
         * 这样让maxArr 指向下一个元素，不会重复判断相等
         */
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            Arrays.sort(nums1)
            Arrays.sort(nums2)

            val minArr = if (nums1.size > nums2.size) nums2 else nums1
            val maxArr = if (nums1.size > nums2.size) nums1 else nums2

            val arrList = mutableListOf<Int>()
            var start = 0
            for (num in minArr) {
                for (i in start until maxArr.size) {
                    if (num == maxArr[i]) {
                        arrList.add(num)
                        start = i + 1
                        break
                    }
                }
            }

            return arrList.toIntArray()
        }
    }

}