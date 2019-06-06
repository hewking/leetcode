package leetcode

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * Created by test
 * Date 2019/6/7 1:29
 * Description
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的原地算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object RotateArray{

    class Solution {
        /**
         * 思路：
         * 第一种解法
         */
        fun rotate(nums: IntArray, k: Int): Unit {
            val len = nums.size
            for (i in nums.indices) {
                if (i + k >= len) {
                    nums[i + k - len] = nums[i]
                } else {
                    nums[i + k] = nums[i]
                }
            }
        }

        /**
         * 第二种解法 ，最容易想到可是效率太低
         * O(n * k)
         */
        fun rotate2(nums: IntArray, k: Int): Unit {
            for (i in 0 until k) {
                val tmp = nums.last()
                var i = nums.size - 1
                while (i > 0) {
                    nums[i] = nums[i-1]
                    i--
                }
                nums[0] = tmp
            }
        }

}