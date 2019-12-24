package leetcode

import java.lang.StringBuilder
import java.util.*

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * Created by test
 * Date 2019/12/22 20:30
 * Description
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
[".Q..",  // 解法 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // 解法 2
"Q...",
"...Q",
".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object NQueue {
    class Solution {

        /**
         * 存放答案
         */
        val ans = mutableListOf<List<String>>()

        /**
         * 思路：
         * https://leetcode-cn.com/problems/n-queens/solution/javahui-su-fa-si-lu-jian-dan-qing-xi-qing-kan-dai-/
         * 回溯法
         * 大佬讲解
         * https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
         */
        fun solveNQueens(n: Int): List<List<String>> {
            var res = ""
            for (i in 0 until n) {
                res += '.'
            }
            val queens = mutableListOf<String>()
            for (j in 0 until n) {
                queens.add((res))
            }
            backTrack(0,queens)
            return ans
        }

        /**
         * 回溯法框架
         * res = []
         * backTrack(路径，选择列表){
         *  if 满足条件
         *  res.add(路径)
         *  return
         *  for(选择 in 选择列表) {
         *   做选择
         *   backTrack(路径，选择列表)
         *   撤销选择
         * }
         */
        fun backTrack(row: Int ,queens: MutableList<String>) {
            if (queens.size == row) {
                ans.add(queens)
                return
            }
            val n = queens[row].length
            for (col in 0 until n) {
                if (!isValid(queens,row,col)) {
                    continue
                }
                val sb = StringBuilder(queens[row])
                sb[col] = 'Q'
                queens[row] = sb.toString()
                backTrack(row + 1,queens)
                sb[col] = '.'
                queens[row] = sb.toString()
            }

        }

        fun isValid(queens: MutableList<String>,row: Int,col: Int):Boolean {
            val n = queens.size
            // 检查列上是否有冲突
            for (i in 0 until n) {
                if (queens[i][col] == 'Q'){
                    return false
                }
            }

            // 检查右上方是否有皇后冲突
            var j = col + 1
            for (i in row - 1 .. 0) {
                if (j <= n) {
                    if (queens[i][j] == 'Q') {
                        return false
                    }
                }
                j ++
            }
            // 检查左上方是否有皇后冲突
            var k = col - 1
            for (i in row - 1 .. 0) {
                if (k>=0){
                    if (queens[i][k] == 'Q') {
                        return false
                    }
                }
                k--
            }
            return true
        }
    }
}