package leetcode.search

import java.util.*

object BinarySearch {

    @JvmStatic
    fun main(args : Array<String>) {
        val arr = arrayOf(23,21,43,23,54,64,12,78)
//        var arr = arrayOf(1,2,4,7,12)
//        print(binarySearch(arr,4))
        quickSort(arr,0,arr.size -1)
        arr.forEach {
            print("$it ")
        }
    }

    private fun binarySearch(arr: Array<Int>, target: Int): Int{
        var left = 0
        var right = arr.size -1
        var m = -1
        while (left < right) {
            m = (left + right) / 2
            if (target > arr[m]) {
                left = arr[left + 1]
            } else if (target < m) {
                right = arr[right -1]
            } else {
                return m
            }
        }
        return -1
    }

    private fun quickSort(arr : Array<Int>,left : Int ,right : Int){
        if (left >= right) {
            return
        }
        val part = partication(arr,left,right)
        quickSort(arr,left,part - 1)
        quickSort(arr,part + 1,right)
    }

    private fun partication(arr: Array<Int>, start: Int, end: Int): Int {
        var left = start
        var right = end
        var target = arr[left]
        while (left < right) {
            while (left < right && arr[right] >= target) {
                right --
            }
            arr[left] = arr[right]
            while (left < right && arr[left] <= target) {
                left ++
            }
            arr[right] = arr[left]
        }
        arr[left] = target
        return left
    }

}