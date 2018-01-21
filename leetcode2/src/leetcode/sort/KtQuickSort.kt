package leetcode.sort

/**
 * Created by test on 2017/12/21.
 */
object KtQuickSort{

    @JvmStatic
    fun main(args :Array<String>) {
        val arr = arrayOf(3,2,5,23,15,32,7,97)
        arr.forEach {
            println(it)
        }
        quickSort(arr,0,arr.size - 1)
        arr.forEach {
            println(it)
        }    }

    fun quickSort(arr :Array<Int>,start : Int,end : Int) {
        if (start > end) {
            return
        }
        val index = partition(arr,start,end)
        quickSort(arr,start,index -1)
        quickSort(arr,index + 1,end)
    }

    /**
     * 快速排序分割算法主要两点目标
     * 1. 选定一个值 使数组所有它下标左边的数都比它小 右边都比它大
     * 2. 返回该值下标
     */
    private fun partition(arr :Array<Int>,start: Int, end: Int): Int {
        val value = arr[start]
        var i = start
        var j = end
        while (i < j) {
            while (i < j && value <= arr[j]) {
                j --
            }
            arr[i] = arr[j]
            while (i < j && value >= arr[i]) {
                i ++
            }
            arr[j] = arr[i]
        }
        arr[i] = value
        // 在循环过程中 start 改变
        return i
    }

}