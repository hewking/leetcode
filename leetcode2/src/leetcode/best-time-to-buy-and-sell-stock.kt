package leetcode

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * Created by test
 * Date 2019/9/29 11:21
 * Description
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Test {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    class Solution {
        /**
         *  暴力法：
         *  从i [0,size - 1] 开始遍历。第j 天价格减去 i天价格
         *  然后求出所有价格的最大值既得
         *  时间复杂度： O(n^2)
         *  空间复杂度：O(1)
         */
        fun maxProfit(prices: IntArray): Int {
            var profit = 0
            for (i in prices.indices) {
                for (j in (i + 1) until prices.size ) {
                    profit = Math.max(profit,prices[j] - prices[i])
                }
            }
            return profit
        }

        /**
         * DP 思想：
         * 1. 当前天买入价格最小值 min,记录价格
         * 2. 当天价格卖出值 max ，记录价格
         * 3. 最大利润 max - min
         */
        fun maxProfit2(prices: IntArray): Int {
            if (prices.size <= 1) {
                return 0
            }
            var maxProfit = 0
            var min = prices[0]
            for (i in 1 until prices.size) {
                maxProfit = Math.max(prices[i] - min,maxProfit)
                min = Math.min(prices[i],min)
            }
            return maxProfit
        }
    }

}