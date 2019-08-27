package leetcode

import java.util.*

/**
 * 384. 打乱数组
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * Created by test
 * Date 2019/7/19 1:18
 * Description
 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shuffle-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object ShffleAnArray {

    @JvmStatic
    fun main(args: Array<String>) {
        Solution(arrayOf(3,2,5,6,34,32,13,87).toIntArray()).shuffle2()
    }

    class Solution(nums: IntArray) {

        private var arr: IntArray = nums.copyOf()

        /** Resets the array to its original configuration and return it. */
        fun reset(): IntArray {
            return arr
        }

        /** Returns a random shuffling of the array. */
        fun shuffle(): IntArray {
            val retval = arr.copyOf()
            for (i in 0 until retval.size) {
                val tmp = retval[i]
                val j = (Math.random() * (retval.size - 1)).toInt()
                retval[i] =  retval[j]
                retval[j]= tmp
            }
            return retval
        }

        fun shuffle2(): IntArray {
            val retval = arr.copyOf()
            val random = Random()
            for (i in retval.size - 1 downTo 0) {
                val x  = random.nextInt(i + 1)
                println(x)
                val t = retval[i]
                retval[i] = retval[x]
                retval[x]  = t
            }
            return retval
        }

    }

}