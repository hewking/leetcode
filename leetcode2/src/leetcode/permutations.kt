package leetcode

import java.util.*

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object Permutations {
    class Solution {

        /**
         *  思路：
         *  排列组合总数 A3 ^ 3
         *
         *  回溯法注意三点： 1. 要对所有候选解进行遍历
         *                  2. 候选解不符合条件 则返回上一步，再进行下一步
         *                    3. 需要一个标志，结束
         */
        fun permute(nums: IntArray): List<List<Int>> {
            val list = mutableListOf<List<Int>>()
            if(nums.size == 1) {
                list.add(nums.toMutableList())
            } else {
                backTrack(nums.size,list , nums.toList(),0)
            }
            return list
        }

        fun backTrack(n: Int,nums: MutableList<List<Int>>,list: List<Int>,first: Int) {
            if (n == first) {
                nums.add(list.toMutableList())
            } else {
                for (i in first until n) {
                    Collections.swap(list,first,i)
                    backTrack(n,nums,list,first + 1)
                    Collections.swap(list,first,i)
                }
            }
        }
    }
}