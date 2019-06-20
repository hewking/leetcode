package leetcode

/**
 * https://leetcode-cn.com/problems/nim-game/
 * 292. Nim 游戏
 * Created by test
 * Date 2019/6/20 22:53
 * Description
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

示例:

输入: 4
输出: false
解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/nim-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object NimGame {

    class Solution {

        /**
         * 思路：
         * 开始想复杂了。这个题真牛逼
         * 首先看怎样才会赢，先手。并且如果第一手没赢对于第二个人来说他也是先手。
         * n<=3 a 赢 n == 4 b赢
         * n == 5 a赢
         * n == 6 a
         * n== 7 a
         * n == 8 b
         * 所以谁面对4,8,12,16..谁输
         */
        fun canWinNim(n: Int): Boolean {
            return n % 4 != 0
        }
    }
}