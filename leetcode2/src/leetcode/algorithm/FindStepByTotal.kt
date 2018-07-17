package leetcode.algorithm

/**
 * 总共有n个台阶 ，每次只能移动 1步 或者两步 总共有多少种方法
 *
 * 分析：采用回溯法，每次只能移动1，2步。到最后到 n 步 必然也是移动一步或者两
 * 如果步数 到 0，那么正解，否则往前回溯
 */
object FindStepByTotal {

    val mSteps = arrayOfNulls<Int>(10)
    var s = 1

    @JvmStatic
    fun main(args : Array<String>) {
        trail(4)
    }

    private fun trail(n: Int) {
        var step = n
        for (i in 1..2) {
            if (step < i) {
                break
            }
            mSteps[s++] = i
            var step = step - i
            if (step == 0) {
                printSteps()
            } else {
                trail(step)
            }
            step += i
            mSteps[s--] = 0
        }
    }

    private fun printSteps() {
        mSteps.forEachIndexed { index, i ->
            print("第$index 次 走 : $i 步")
        }
        println()
    }

}