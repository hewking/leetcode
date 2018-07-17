package leetcode.algorithm

object Solution {

    @JvmStatic
    fun main(args : Array<String>) {

        println(letterCombinations("23"))

    }

    fun letterCombinations(digits: String): List<String> {
        val list = mutableListOf<String>()
        val phones = arrayOf("","","abc","def","ghi","jkl","mno","pqrs","tuv","exyz")
        backTrack(list,phones,digits,"")
        return list.sortedBy { it }
    }

    fun backTrack(list: MutableList<String>, phones: Array<String>, digits: String, s: String) {
        if (digits.isEmpty()) {
            if (s.isNotEmpty()) {
                list.add(s)
            }
            return
        }
        val index = digits[0] - '0'
        for (ch in phones[index].toCharArray()) {
            backTrack(list,phones,digits.substring(1),s + ch)
        }
    }
}