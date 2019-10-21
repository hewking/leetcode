package leetcode

import java.util.*

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-21 11:32
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object TopKFrequentElements {

    class Solution {
        /**
         * 思路： key-value 形式保存某数的集合
         * 比如1 出现3次，那么 {"1":3} 然后在获取第k个
         * 暴力法：
         *
         */
        fun topKFrequent(nums: IntArray, k: Int): List<Int> {
            val map = mutableMapOf<Int,Int>()
            nums.forEach {
                val value = map[it]
                if (value == null) {
                    map[it] = 1
                } else {
                    map[it] = value + 1
                }
            }

            val frequentsList = map.entries.sortedByDescending {
                it.value
            }

            val list = mutableListOf<Int>()
            for (i in 0 until k) {
                list.add(frequentsList[i].key)
            }
            return list
        }
    }

}

fun main(args: Array<String>) {
    TopKFrequentElements.Solution().topKFrequent(intArrayOf(3,0,1,0),1)
}