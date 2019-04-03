package leetcode

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
        */

object MaxSubArray {

    @JvmStatic
    fun main(args : Array<String>) {
        var array = arrayOf(-2,1,-3,4,-1,2,1,-5,4)
        println(maxSubArray(array))
    }

    fun maxSubArray(arr : Array<Int>) : Int{
        var maxSub = 0
        for (i in 0 until arr.size) {
            for (j in i until arr.size) {
                var childSub = 0
                for (k in i until j + 1) {
                    childSub += arr[k]
                }
                if (maxSub < childSub) {
                    maxSub = childSub
                }
            }
        }
        return maxSub
    }

}