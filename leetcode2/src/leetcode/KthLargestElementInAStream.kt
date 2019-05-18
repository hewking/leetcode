package leetcode

import java.util.*

/**
 * 数据流中的第k大的元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * Created by test
 * Date 2019/5/18 15:07
 * Description
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

示例:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
说明:
你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 */
object KthLargestElementInAStream {


    /**
     * 思路:
     * 1.第k大的问题都可以通过优先队列来解决
     * 2.优先队列不需要自己构造，如果自己构造也需要几个方法
     * deleteMin insert findMin 等
     * 3.优先队列大小为k ，
     * 4.如果元素小于k 则直接offer
     * 5.如果元素大小已经达到k 则比较val 与 顶部元素大小相比较
     * 6.如果小于 则废弃，因为是求第k大元素
     */
    class KthLargest(k: Int, nums: IntArray) {

        val q  = PriorityQueue<Int>()
        val k1 = k

        fun add(`val`: Int): Int {
            if (q.size < k1) {
                q.offer(`val`)
            } else {
                if (`val` < q.peek()){
                    q.poll()
                    q.offer(`val`)
                }
            }
            return q.peek()
        }

    }

}