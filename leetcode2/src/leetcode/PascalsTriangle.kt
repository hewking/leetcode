package leetcode

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 * Created by test
 * Date 2019/6/7 1:05
 * Description
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object PascalsTriangle {

    class Solution {

        /**
         * 思路:
         *秒过题目
         * 1.主要下一层需要上一层的数据，所幸是一个List<List>
         */
        fun generate(numRows: Int): List<List<Int>> {
            val rows = mutableListOf<List<Int>>()
            for (i in 0 until numRows) {
                val row = mutableListOf<Int>()
                rows.add(row)
                for (j in 0 until  i + 1) {
                    if (i == 0) {
                        row.add(1)
                    } else {
                        if (j == 0 || j == i) {
                            row.add(1)
                        } else {
                            row.add(rows[i-1][j-1] + rows[i-1][j])
                        }
                    }
                }
            }
            return rows
        }
    }

}