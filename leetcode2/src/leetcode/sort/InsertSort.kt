package leetcode.sort

object InsertSort{

    @JvmStatic
    fun main(args : Array<String>) {

        var arr = arrayOf(23,54,23,54,76,28,98,43,4)
        sort(arr)
        arr.forEach {
            print("$it ")
        }
    }

    /**
     * 插入排序像 打扑克斗地主 排序
     * 1.从数组i = 1 位置开始
     * 2.保存 var v = arr[i]
     * 3.循环内部 已排好序的 部分，跟 v 比较，如果大于 则 arr[j+1] = arr[j]
     * 最终 arr[j+1] = v
     */
    private fun sort(arr: Array<Int>) {
        var v = 0
        var j = 0
        val size = arr.size
        for (i in 1 until arr.size) {
            v = arr[i]
            j = i-1
            while(j >= 0 && arr[j] > v) {
                arr[j+1] = arr[j]
                j--
            }
            arr[j+1] = v
        }
    }

}