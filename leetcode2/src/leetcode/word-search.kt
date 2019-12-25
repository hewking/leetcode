package leetcode

/**
79. 单词搜索
https://leetcode-cn.com/problems/word-search/
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
['A','B','C','E'],
['S','F','C','S'],
['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        **/

object WordSearch {
    class Solution {

        var ans = false

        /**
         * 回溯法：
         * res= []
         * backTrack(路径，选择集) {
         *  if (结束条件）{
         *  res.add(路径)
         *  }
         *  for (选择 in 选择集) {
         *      选择
         *      backTrack(路径，选择集)
         *      撤销选择
         *  }https://leetcode-cn.com/problems/word-search/solution/java-shen-du-sou-suo-hui-su-by-deep2018530/
         * }
         */
        fun exist(board: Array<CharArray>, word: String): Boolean {
            for (i in 0 until board.size) {
                for (j in 0 until board[i].size) {
                     if(backTrack(board,word,i,j,0)){
                         return true
                     }
                }
            }
            return false
        }

        val rows = intArrayOf(0,1,0,-1)
        val cols = intArrayOf(1,0,-1,0)

        fun backTrack(board: Array<CharArray>,word:String,x: Int,y: Int,start: Int):Boolean {
            // 判断越界
            if(x >= board.size || x < 0 || y >= board[0].size || y < 0) return false
            if (board[x][y] != word[start]) return false
            if (word.length - 1 == start ) {
                return true
            }
            board[x][y] = '.'
            for (i in 0 until 4) {
                if (backTrack(board,word,x + rows[i], y + cols[i],start + 1)){
                    return true
                }
            }
            board[x][y] = word[start]
            return false
        }
    }
}