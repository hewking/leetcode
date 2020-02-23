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
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var reverseHead = reverseLinkedList(head)
            var count = 0
            var preNode = reverseHead
            var curNode = preNode?.next
            while (count < n - 1) {
                curNode = curNode?.next
                preNode = preNode?.next
                count ++
            }
            preNode?.next = curNode?.next
            reverseHead = reverseLinkedList(reverseHead)
            return reverseHead
        }

        fun reverseLinkedList(head: ListNode?): ListNode? {
            if (head?.next == null) {
                return head
            }
            val p = ListNode(-1)//拟一个头节点
            p.next = head
            var nextNode: ListNode? = head.next
            while (nextNode != null) {
                //后一个节点调整到最前
                head.next = nextNode.next
                nextNode.next = p.next
                p.next = nextNode
                nextNode = head.next
            }
            return p.next
        }
    }

}