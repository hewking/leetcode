package leetcode

/**
 * @Classname kthSmallest
 * @Description TODO
 * @Date 2020-05-16 14:00
 * @Created by jianhao
 * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。

你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。



示例 1：

输入：mat = [[1,3,11],[2,4,6]], k = 5
输出：7
解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
[1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
示例 2：

输入：mat = [[1,3,11],[2,4,6]], k = 9
输出：17
示例 3：

输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
输出：9
解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
示例 4：

输入：mat = [[1,1,10],[2,2,9]], k = 7
输出：12
 */

object KthSmallest {
    class Solution {
        fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
            val list = kthSmallestCombiles(mutableListOf(),mat)
            val list2 = list.map { it -> it.reduce { acc, i ->
                acc + i
            } }
            list2.sorted()

            return list2[k]
        }

        fun kthSmallestCombiles(list:List<IntArray>,mat:Array<IntArray>): List<IntArray> {

            val len = mat.size



            return list
        }

        fun findArray(list:MutableList<IntArray>,mat:Array<IntArray>,res:IntArray){
            if (res.size == mat.size) {
                list.add(res)
                return
            }
        }
    }



}