package leetcode

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object JumpGame {

    class Solution {

        private var canJump = false
        /**
         *  思路：这一题跟加油站很相似
         */
        fun canJump(nums: IntArray): Boolean {
            this.jump(0,nums)
            return canJump
        }

        fun jump(startPos: Int,nums: IntArray){
            if (startPos >= nums.size - 1) {
                canJump = true
                return
            }
            for (i in 1 .. nums[startPos]) {
                jump(startPos + i,nums)
            }
        }
    }

}

fun main(){
    println(JumpGame.Solution().canJump(intArrayOf(8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5)))

}
