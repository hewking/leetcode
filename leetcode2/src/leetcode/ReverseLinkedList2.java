package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 难度 ： 中
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * Created by test
 * Date 2019/4/29 0:48
 * Description
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return reverse(head,m,n,0);
    }

    public ListNode reverse(ListNode head,int m ,int n,int height) {
        if (head == null || head.next == null) {
            return head;
        }
        if (height >= n) {
            return head;
        }
        ListNode pNode = reverse(head,m,n,height ++);
        if (height > m) {
            head.next.next = head;
            head.next = null;
        }

        return pNode;
    }

    /**
     * 1->2->3->4->5->NULL, m = 2, n = 4
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
//        ListNode pNode = new ListNode(-1);
////        pNode.next = head;
////
////        for (int i = 1 ; i < m ; i ++) {
////            head = head.next;
////        }
////
////        // 反转的次数
////        ListNode nextNode = head.next;
////        for (int i = m ; i < n ; i ++) {
////            head.next = nextNode.next;
////            nextNode.next = head;
////            pNode.next = nextNode;
////            nextNode = nextNode.next;
////        }
////        return pNode.next;

        ListNode pNode = new ListNode(-1);
        pNode.next = head;
        ListNode pre = pNode;
        for (int i = 1 ; i < m ; i ++) {
            pre = pre.next;
        }

        // 反转的次数

        head = pre.next;
        for (int i = m ; i < n ; i ++) {
            ListNode nextNode = head.next;
            head.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
            //nextNode = head.next;
        }
        return pNode.next;
    }

}
