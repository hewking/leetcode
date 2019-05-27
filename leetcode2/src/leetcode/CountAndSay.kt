package leetcode

/**
 * 38. 报数
 * https://leetcode-cn.com/problems/count-and-say/
 * Created by test
 * Date 2019/5/23 1:18
 * Description
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。



示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 */
object CountAndSay {

    class Solution {
        /**
         * 思路:
         * 1.首先题目要看懂，说的报数的是n的下一项
         *2.首先知道传入的n是趟数，所以必定是有n次，第一次已知 可以直接返回结果
         * 3.用count计数，c作为每次对比的字符的临时变量
         * 4.每一轮重置 count ,c
         * 5.从高位开始计数，到每一轮循环的末尾 手动循环外添加 报数结果
         *
         */
        fun countAndSay(n: Int): String {
            var s = "1"
            if (n == 1) return "1"
            val rs = StringBuffer()
            var count = 0
            var c = s[0]
            for (i in 2 ..n) {
                count = 0
                c = s[0]
                for (j in 0 until s.length){
                    if (c == s[j]) {
                        count ++
                    } else {
                        rs.append(count)
                        rs.append(c)
                        c = s[j]
                        count = 1
                    }
                    if (j == s.length -1) {
                        rs.append(count)
                        rs.append(c)
                    }
                }
                s = rs.toString()
                rs.delete(0,rs.length)
            }
            return s
        }
    }

}