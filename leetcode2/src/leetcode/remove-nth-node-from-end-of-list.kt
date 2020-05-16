package leetcode

import leetcode.structure.ListNode

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object  RemoveNthNodeFromEndOfList {

    class Solution {

        /**
         * 快慢指针法,当快指针到最后面时候，慢指针正好到中间。
         * 如果我们给定一个index，这个值每次循环+1,然后，就可以通过与n的关系
         * 删除一个节点即可
         */
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var p = head
            var slow = p
            var fast = p
            var index = 0
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next.next
                index ++

            }
            return head
        }

    }

}