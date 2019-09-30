package leetcode

import java.util.*

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * Created by test
 * Date 2019/9/30 18:12
 * Description
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object MergeIntervals {

    @JvmStatic
    fun main(args : Array<String>) {
        Solution().merge2(arrayOf(intArrayOf(1,4), intArrayOf(2,3))).forEach {
            println()
            it.forEach {
                print(it)
            }
        }
    }

    class Solution {
        /**
         * 思路：
         * 1. 数组内部排序
         * 2. 外部大数组排序
         *
         */
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.isEmpty()) {
                return intervals
            }
            intervals.map {
                it.sort()
            }
            intervals.sortBy {
                it[0]
            }
            val intervalsList = mutableListOf<IntArray>()
            var tmpArr = IntArray(2)
            tmpArr[0] = intervals[0][0]
            intervalsList.add(tmpArr)
            for (i in 1 until intervals.size) {
                tmpArr[1] = intervals[i - 1][1]
                if (intervals[i][0] <= intervals[i - 1][1]) {
                    tmpArr[1] = Math.max(intervals[i][1],intervals[i - 1][1])
                } else {
                    tmpArr = IntArray(2)
                    intervalsList.add(tmpArr)
                    tmpArr[0] = Math.min(intervals[i][0],intervals[i - 1][1])
                }
            }
            tmpArr[1] = Math.max(intervals.last()[1],intervals[intervals.size - 1][1])
            return intervalsList.toTypedArray()
        }

        fun merge2(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.isEmpty()) {
                return intervals
            }
            intervals.sortBy {
                it[0]
            }
            val intervalsList = mutableListOf<IntArray>()
            for (i in 0 until intervals.size) {
               if (intervalsList.isEmpty() || intervalsList.last()[1] < intervals[i][0]) {
                   intervalsList.add(intervals[i])
               } else {
                   intervalsList.last()[1] = Math.max(intervalsList.last()[1],intervals[i][1])
               }
            }
            return intervalsList.toTypedArray()
        }

    }

}