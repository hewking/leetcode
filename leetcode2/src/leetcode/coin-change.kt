package leetcode

/**
 *
322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * Created by test
 * Date 2019/12/1 12:01
 * Description
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object CoinChange {

    class Solution {
        /**
         * 回溯法，暴力法
         * 跟跳跃游戏，加油站一类解法
         */
        fun coinChange(coins: IntArray, amount: Int): Int {
            return coin(0,coins,amount)
        }

        fun coin(coinIndx: Int,coins: IntArray,amount: Int): Int {
            if (amount == 0) {
                return 0
            } else if (coinIndx < coins.size && amount > 0){
                val maxCoin = amount / coins[coinIndx]
                var minCost = Int.MAX_VALUE
                for (i in 0 .. maxCoin) {
                    if (amount >= coins[coinIndx] * coinIndx) {
                        val res = coin(coinIndx + 1, coins,amount - coins[coinIndx] * i)
                        if (res != -1) {
                            minCost = Math.min(minCost,res + i)
                        }
                    }
                }
                return if (minCost == Int.MAX_VALUE) {
                    -1
                } else minCost
            }
            return -1
        }
    }

}