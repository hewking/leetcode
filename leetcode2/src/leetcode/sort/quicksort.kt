package leetcode.sort

/**
 * Created by test on 2018/1/7.
 */
object quicksort {

    @JvmStatic
    fun main(args : Array<String>) {
        var arr = arrayOf(5,43,73,12,6,86,2334,76,43,23)
        arr.forEach {
            print("${it} ")
        }
        sort(arr,0,arr.size - 1)
        arr.forEach {
            print("${it} ")
        }    }

    fun sort(arr : Array<Int>,start : Int, end : Int) {
        if (start >= end) {
            return
        }

        val index = partition(arr,start,end)
        sort(arr,start,index - 1)
        sort(arr,index + 1 , end)

    }

    private fun partition(arr: Array<Int>, start: Int, end: Int): Int {
        var index = arr[start]
        var i = start
        var j = end
        while (i < j) {
            while (i < j && index <= arr[j]) {
                j --
            }
            arr[i] = arr[j]
            while (i < j && arr[i] <= index ) {
                i ++
            }
            arr[j] = arr[i]
        }
        arr[i] = index
        return i

    }

}