package leetcode

/**
 * Created by test
 * Date 2020/2/23 20:40
 * Description
 */

object SortAnArray {

    class Solution {

        fun sortArray(nums: IntArray): List<Int> {

            quickSort(nums,0,nums.size - 1)
            return nums.toList()
        }

        fun quickSort(nums: IntArray,start: Int, end: Int) {
            if (start > end) {
                return
            }

            val k = partition(nums,start,end)
            quickSort(nums,start,k - 1)
            quickSort(nums,k + 1,end)
        }

        fun partition(nums: IntArray,start: Int,end: Int) : Int {
            val target = nums[start]
            var i = start
            var j = end
            while (i < j) {
                while (i < j && nums[j] >= target){
                    j--
                }
                nums[i] = nums[j]
                while (i < j && nums[i] <= target) {
                    i ++
                }
                nums[j] = nums[i]
            }
            nums[i] = target
            return i
        }

    }

}