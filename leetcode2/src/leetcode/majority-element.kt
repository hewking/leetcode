package leetcode

/**
 *
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @Classname `majority-element`
 * @Description TODO
 * @Date 2020-04-29 16:07
 * @Created by jianhao
 *
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 */

object MajorityElement2 {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    /**
     * 思路：
     * 1. 先排序
     * 2. 然后返回排序后数组中间的数
     */
    fun majorityElement(nums: IntArray): Int {
        val majorityNum = nums.size.div(2)
        nums.sort()
        return nums[nums.size.div(2)]
    }

}