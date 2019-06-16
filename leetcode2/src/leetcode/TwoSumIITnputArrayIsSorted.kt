package leetcode

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 167. 两数之和 II - 输入有序数组
 * Created by test
 * Date 2019/6/16 10:31
 * Description
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object TwoSumIITnputArrayIsSorted{

    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            // check param valid
            val res = IntArray(2)
            for (i in 0 until numbers.size - 1) {
                for (j in (i + 1) until numbers.size) {
                    if (numbers[i] + numbers[j] == target) {
                        res[0] = i + 1
                        res[1] = j + 1
                        break
                    }
                }
            }
            return res
        }

        /**
         * 思路:
         * 傻逼了，没有利用起来有序数组这个特性
         */
        fun twoSum2(numbers: IntArray, target: Int): IntArray {
            // check param valid
            val res = IntArray(2)
            var l = 0
            var r = numbers.size - 1
            while (l < r) {
                if (numbers[l] + numbers[r] == target) {
                    res[0] = l + 1
                    res[1] = r + 1
                    break
                } else if (numbers[l] + numbers[r] < target)  {
                    l ++
                } else {
                    r --
                }
            }
            return res
        }
    }

}