package leetcode

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * Created by test
 * Date 2019/7/17 0:21
 * Description
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ClimbingStairs {

    @JvmStatic
    fun main(args: Array<String>) {
        println(Solution().climbStairs(2))
        println(Solution().climbStairs(3))
        println(Solution().climbStairs(44))
    }


class Solution {

    /**
     * 思路：
     * 1. 很常见的动态规划的题，回溯法
     * 2. 以前也是做过，不过稍微复杂一点，需要列出路径
     * 3.大概就是递归，通过到n的步骤分解，n-1,n-2  两种方式可以到达n,也就是说
     * fun(n-1) + fun(n-2) 就是fun(n)的步数
     * 4.递归当然有基准情况，正整数n，说明n > 0 ,那么n - 1, n- 2  最小得值 0,1为基准情况
     * 5.接下来就是递归问题了 对每次移动的步数为1 2 相减，再加上sum 数量
     */
    fun climbStairs(n: Int): Int {
        if (n == 0 || n == 1) {
            return 1
        }
        var sum = 0
        for (i in 1..2) {
            sum += climbStairs(n - i)
        }
        return sum
    }

    /**
     * 非递归法
     * 1.从递归版本可知，基准情况是n = 1  n = 2@
     * 从n = 3 开始可分解为 n1 + n2
     * n = 4  ， n3 + n2
     * ...
     */
    fun climbStairs2(n: Int): Int {
        if (n == 1 || n == 2) {
            return n;
        }
        var value = 0;
        var n1 = 1
        var n2 = 2
        for (i in 3..n) {
            value = n1 + n2;
            n1 = n2
            n2 = value
        }
        return value
    }
}
}
