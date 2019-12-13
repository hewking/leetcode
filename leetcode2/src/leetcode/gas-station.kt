package leetcode


/**
 *
 * 134. 加油站
 * https://leetcode-cn.com/problems/gas-station/
 *
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:

输入:
gas  = [2,3,4]
cost = [3,4,3]

输出: -1

解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object GasStation {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    class Solution {

        /**
         * 思路：
         * 真的牛逼的解法
         * https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
         */
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val n = gas.size
            for (i in 0 until n) {
                var remain = gas[i]
                var j = i
                while (remain - cost[j] >= 0) {
                    remain = remain - cost[j] + gas[(j + 1) % n]
                    j = (j + 1) % n
                    // 相当于绕了一圈了
                    if (i == j) {
                        return i
                    }
                }
            }
            return -1
        }

        /**
         * 贪心算法思路：
         * 1. 必须总油量大于消耗,代表一定可以完成行驶，接下来就是找最开始位置
         * 2. 如果gas[i] - cost[i] < 0 无法到达下一个加油站，则重新开始 选择当前加油站
         */
        fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
            var total = 0
            var start = 0
            var remain = 0
            for (i in 0 until gas.size) {
                total += gas[i] - cost[i]
                if (remain < 0) {
                    remain = gas[i] - cost[i]
                    start = i
                } else {
                    remain += gas[i] - cost[i]
                }
            }
            return if (total >= 0) start else -1
        }

    }
}
