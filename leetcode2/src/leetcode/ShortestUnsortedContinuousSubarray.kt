package leetcode

import java.util.*

/**
 * Created by test
 * Date 2019/6/18 0:20
 * Description
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 581. 最短无序连续子数组
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ShortestUnsortedContinuousSubarray {

    class Solution {

        /**
         * 思路：
         * 1.先排序，因为如果步排序是不知道谁是最大的值
         * 2.掐头去尾
         * 3.l 循环中的<= 是因为重复元素，和已经排序好的 [1,2,3,4]的影响
         */
        fun findUnsortedSubarray(nums: IntArray): Int {
            val arr = nums.copyOf()
            Arrays.sort(nums)
            var l = 0
            var r = nums.size -1
                while (l <= r && nums[l] == arr[l]) {
                    l++
                }
                while (l < r && nums[r] == arr[r]) {
                    r--
                }
            return r - l + 1
        }
    }
}