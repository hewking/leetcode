package leetcode.sort

object SelectionSort {

    @JvmStatic
    fun main(args : Array<String>) {
        var arr = arrayOf(23,54,23,54,76,28,98,43,4)
        slection(arr)
        arr.forEach {
            print("$it ")
        }
    }

    /**
     * 选择排序把数组分为两部分 排好序的，未排好序的
     * 1.从数组 i =1 开始寻找 未排好序的最小值
     * 2.数组第i=0 默认排好序的，从1 找到的最小值 作交换
     * 3.循环往复
     */
    private fun slection(arr: Array<Int>) {
        var min = 0
        for(i in 0 until arr.size) {
            min = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            var v = arr[min]
            arr[min] = arr[i]
            arr[i] = v
        }
    }

}