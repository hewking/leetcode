package leetcode

import java.util.ArrayList



/**
 * 78. 子集
 *https://leetcode-cn.com/problems/subsets/
 *
 *给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
[3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        **/

object Subsets {

    class Solution {

        val ans = mutableListOf<List<Int>>()


        fun subsets(nums: IntArray): List<List<Int>> {
            nums.sort()
            subset2(nums, mutableListOf(),0)
            return ans
        }

        /**
         * 思路：
         * 有点问题，没考虑周全
         */
        fun subset(nums:IntArray,ans: MutableList<List<Int>>,index: Int) {
            if (index == nums.size) {
                ans.add(mutableListOf())
                return
            }
            ans.add(mutableListOf(nums[index]))
            for (i in index + 1 until nums.size) {
                ans.add(mutableListOf(nums[index],nums[i]))
            }
            if (nums.size - index > 2) {
                val lastElement = nums.toMutableList().subList(index,nums.size)
                ans.add(lastElement)
            }
            subset(nums,ans,index + 1)
        }

        /**
         * 思路2：
         * 跟全排列有点像
         * https://leetcode-cn.com/problems/subsets/solution/xiang-xi-jie-shao-di-gui-hui-su-de-tao-lu-by-reedf/
         */
        fun subset2(nums:IntArray,list: MutableList<Int>,index: Int) {
            ans.add(list.toList())
            for (i in index until nums.size) {
                list.add(nums[i])
                subset2(nums,list,i + 1)
                list.removeAt(list.size - 1) // 递归完每次移除添加的
            }
        }


    }

}