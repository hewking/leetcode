package leetcode

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5
 */
object LengthOfLastWord {

    @JvmStatic
    fun main(args : Array<String>) {
        println(solution("hel@lo wor@ld"))
    }

    @JvmStatic
    fun solution(str : String) : Int {
        val charArray = str.toCharArray()
        var num = 0

        val checkWord = { ch : Char ->
            ch in 'a'..'z' || (ch in 'A' .. 'Z')
        }

        for (i in 0 until charArray.size) {
            val ch = charArray[i]
            if (ch == ' ' && num != 0) {
                num = 0
                continue
            }

            if (!checkWord.invoke(ch)) {
                num = 0
                continue
            }

            num ++

        }
        return num
    }

}