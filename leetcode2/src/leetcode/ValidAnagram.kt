package leetcode

import java.util.*

/**
 *242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * Created by test
 * Date 2019/6/4 1:06
 * Description
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
object  ValidAnagram{

    @JvmStatic
    fun main(args : Array<String>) {
        println(Solution().isAnagram2("anagram","nagaram"))
    }

    class Solution {

        /**
         * 思路
         * 1.遍历s的char
         * 2.遍历过程中查找与t的char相等，如果相等
         * 交换t对应s中的char并且和s遍历的i位置交换
         * O（N2）
         */
        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            if (s == t) return true
            var flag = false
            val sa = s.toCharArray()
            val ta = t.toCharArray()
            for (i in sa.indices) {
                flag = false
                for (j in i until ta.size) {
                    if (sa[i] == ta[j]) {
                        val tmp = ta[j]
                        ta[j] = ta[i]
                        ta[i] = tmp
                        flag = true
                        break
                    }
                }
                if (flag) {
                } else {
                    return false
                }
            }
            return flag
        }

        /**
         * 对s,t进行排序，然后比较是偶相等
         */
        fun isAnagram2(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            if (s == t) return true
            val sa = s.toCharArray()
            val ta = t.toCharArray()
            sa.sort()
            ta.sort()

            return Arrays.equals(sa,ta)
        }
    }

}