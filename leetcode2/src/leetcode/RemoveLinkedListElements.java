package leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head.next != null && head.next.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode node = head;
        while (node.next.val == node.next.next.val) {
            ListNode tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }

        return head;
    }


     public static class ListNode {
          int val;
          ListNode next;
        ListNode(int x) { val = x; }
     }

}
