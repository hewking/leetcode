package leetcode


/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by test
 * Date 2019/12/14 12:21
 * Description
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object LetterCombinationsOfAPhoneNumber {

    class Solution {
        /**
         * 思路:
         * 1. 根据题设digits 取值为2-9 组合的数字字符串
         * 2. 并且2-9 分别对应一组 字母数组，跟phone 键盘一致
         * 3. 对输入的多组组合 比如输入23  通过步骤2 得到 两组数据
         * [[a,b,c],[d,e,f]]
         * 4. 以上数据可以看做 a + [[d,e,f]] , b + [[d,e,f]], c + [[d,e,f]]组合
         * 5。 就可以通过递归，基准情形就是 数据size == 1
         */
        fun letterCombinations(digits: String): List<String> {
            // TODO check param
            if (digits.isEmpty()) {
                return mutableListOf()
            }
            val numLists = mutableListOf<String>()
            for (i in digits.indices) {
                when(digits[i]) {
                    '2' -> {
                        numLists.add("abc")
                    }
                    '3' -> numLists.add("def")
                    '4' -> numLists.add("ghi")
                    '5' -> numLists.add("jkl")
                    '6' -> numLists.add("mno")
                    '7' -> numLists.add("pqrs")
                    '8' -> numLists.add("tuv")
                    '9' -> numLists.add("wxyz")
                }
            }

            val ans = mutableListOf<String>()
            combineDigits(numLists,ans,"")
            return ans
        }

        fun combineDigits(digits: MutableList<String> , ans: MutableList<String>,res: String) {
            if (digits.isEmpty()) {
                ans.add(res)
            } else {
                val temp = digits[0]
                val remain = if (digits.size == 1) mutableListOf() else digits.subList(1,digits.size)
                for (i in temp.indices) {
                    combineDigits(remain,ans,res + temp[i])
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        Solution().letterCombinations("2,3").forEach {
            println(it)
        }
    }

}