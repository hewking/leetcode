package leetcode

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Created by test
 * Date 2019/9/29 12:05
 * Description
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
官方题解：
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
 */

object BestTimeTOBuyAndSellStockII {

    class Solution {

        /**
         * 思路：
         * profits = all(peak) - all(valley)
         * 所有相邻波峰减去波谷 的和
         */
        fun maxProfit(prices: IntArray): Int {
            if (prices.size <= 1) {
                return 0;
            }
            var i = 0;
            var peak = prices[0]
            var valley = prices[0]
            var maxProfit = 0
            while (i < prices.size - 1) {
                while(i < prices.size - 1 && prices[i] >= prices[i + 1]) {
                    i ++
                }
                valley = prices[i]
                while (i < prices.size - 1 && prices[i] <= prices[i + 1])
                    i++
                peak = prices[i]
                maxProfit += peak - valley
            }
            return maxProfit
        }

        /**
         * 连续两个值之间的差，如果为正
         * 那么相加，则是最大利润
         */
        fun maxProfit2(prices: IntArray): Int {
            var maxProfit = 0
            for (i in 1 until prices.size) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i -1]
                }
            }
            return maxProfit
        }

}