package leetcode.algorithm

/**
 * Created by test on 2017/12/22.
 * 给出 2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，写一个函数找到这个数字。


挑战：

一次遍历，常数级的额外空间复杂度


格式：


输入行输入一个数组，最后输出出现一次的数字。


样例输入


[ 1，2，2，1，3，4，3 ]


样例输出


4
 */
object FindNumberOfMany{

    @JvmStatic
    fun main(args : Array<String>) {
        val arr = arrayOf<Int>(1,2,3,1,3,4,3)

        print(findNum(arr))

//        println(0.xor(1))
//        print(1.xor(0.xor(1)))

    }

    fun findNum(arr : Array<Int>) : Int {
        // 其中逻辑运算
        //按位与 &   and
        // 按位或 |  or
        // 异或   ^  xor
        // 非(取反) ~  in
        // 左移 <<   shl
        // 右移  >>  shr
        // 无符号右移 <<<  unshr

        // 与同一个数进行两次异或 还是原值
        var p = 1
        arr.forEach {
            println(it)
            p = it.xor(p)
        }

        return p
    }

}