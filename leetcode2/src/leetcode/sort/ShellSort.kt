package leetcode.sort

object ShellSort{
    @JvmStatic
    fun main(args : Array<String>) {
        var arr = arrayOf(23,54,23,54,76,28,98,43,4)
        shell(arr)
        arr.forEach {
            print("$it ")
        }
    }

    /**
     * 希尔排序
     * 1.弥补插入排序明显的缺点，因为插入排序每一步只移动一步，如果最小值在数组末尾，则需要移动n-1 消耗太大
     * 2.希尔排序 对一个数组，间隔一段距离 再用类似于插入排序的方法
     */
    private fun shell(arr: Array<Int>) {
        val size = arr.size
        var h = 1
        var v = 0
        var j = 0
        while (h < size) {
            h = h *3 +1
        }

        while (h >= 1) {
            for (i in h until size step h) {
                v = arr[i]
                j = i - h
                while (j >= 0 && arr[j] > v) {
                    arr[j + h] = arr[j]
                    j = j-h
                }
                arr[j+h] = v
            }

            h = h / 3
        }
    }
}