package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object UniquePaths {
    class Solution {

        /**
         * 解法：
         * 牛批大佬小学数学解法
         * https://leetcode-cn.com/problems/unique-paths/solution/xiao-xue-ti-java-by-biyu_leetcode/
         */
        fun uniquePaths(m: Int, n: Int): Int {
            if (m <= 0 || n <= 0) {
                return 0
            }
            val more = max(m, n)
            val less = min(m, n)
            val dp = IntArray(less)
            dp.fill(1)
            for (i in 1 until more) {
                for (j in 1 until less) {
                    dp[j] += dp[j - 1]
                }
            }
            return dp[less - 1]
        }

        /**
         * 解法2：
         * 动态规划：
         * 可以看到到达右下角记为二维数组中的dp[m,n]
         * 到达那个位置的路线数等于到达它上方的点的路线数 加上 到达它左边的路线数。
         * 即 dp[m,n]= dp[m,n-1] + dp[m-1,n],即是状态转移公式，接下来找
         * 自顶向下的解法。 然后拓展到自底向上的解法
         * https://leetcode-cn.com/problems/unique-paths/solution/cde-di-gui-qiu-jie-by-rose-chen/
         */

        val paths = Array<IntArray>(101){
            IntArray(101)
        }

        fun uniquePaths2(m: Int, n: Int): Int {
            if(m <= 0 || n <= 0) {
                return 0
            }
            if (m ==1 || n == 1) return 1
            if (m == 2 && n == 2) return 2
            if (m == 3 && n == 2  || n == 3 && m == 2) return 3
            if (paths[m][n] > 0) {
                return paths[m][n]
            }
            paths[m][n-1] = uniquePaths2(m,n-1)
            paths[m-1][n-1] = uniquePaths2(m-1,n)
            return paths[m][n-1] + paths[m-1][n-1]
        }

    }
}