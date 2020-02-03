package leetcode

/**
 * 378. 有序矩阵中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Created by test
 * Date 2020/2/2 18:24
 * Description
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
[ 1,  5,  9],
[10, 11, 13],
[12, 13, 15]
],
k = 8,

返回 13。
说明:
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object KthSmallestElementInASortedMatrix {

    class Solution {

        /**
         * 思路：
         *  错误解法，只能覆盖 从小到大排列的一种情形
         */
        fun kthSmallest2(matrix: Array<IntArray>, k: Int): Int {
            val numSize = matrix.map {
                it.size
            }.reduce({
                pre,cur -> pre + cur
            })
            val n = Math.sqrt(numSize.toDouble())
            val row = Math.ceil(k.div(n))
            val a = Math.floor(k.div(n))
            val col = k - a * n
            return matrix[row.toInt() - 1][col.toInt() - 1]
        }

        /**
         * 思路：
         *  https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/on-java-by-bumblebee/
         *  二分查找解法
         */
        fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
            var low = matrix[0][0]
            var high = matrix[matrix.size - 1][matrix.size - 1]
            while (low < high) {
                var mid = low + (high - low) / 2
                val count = countLessOrEquals(matrix,mid)
                if (count < k) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
            return low
        }

        fun countLessOrEquals(matrix: Array<IntArray>, k:Int) :Int {
            var i = matrix.size - 1
            var j = 0
            var count = 0
            while (i >= 0 && j < matrix[0].size) {
                if (k < matrix[i][j]) {
                    i--
                } else {
                    count += i + 1
                    j++
                }
            }
            return count
        }
    }

}