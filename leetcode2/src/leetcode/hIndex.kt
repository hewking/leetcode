package leetcode

import java.util.*

/**
 * 求H指数
 * https://leetcode.com/problems/h-index/
 * Created by test
 * Date 2019/9/14 18:38
 * Description\
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”



示例:

输入: citations = [3,0,6,1,5]
输出: 3
解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 */

object HIndex {
    class Solution {
        /**
         * 思路：
         * 这道题让我们求H指数，这个质数是用来衡量研究人员的学术水平的质数，定义为一个人的学术文章有n篇分别被引用了n次，那么H指数就是n。
         * 而且wiki上直接给出了算法，可以按照如下方法确定某人的H指数：1、将其发表的所有SCI论文按被引次数从高到低排序；
         * 2、从前往后查找排序后的列表，直到某篇论文的序号大于该论文被引次数。所得序号减一即为H指数。我也就没多想，直接按照上面的方法写出了代码
         *
         * 总结：
         * 1. 遇到数组相关的问题，特别是跟position 有关的问题，首先需要排序
         */
        fun hIndex(citations: IntArray): Int {
            Arrays.sort(citations)
            for (i in citations.indices) {
                if (i > citations[i]) {
                    return i
                }
            }
            return citations.size
        }
    }
}