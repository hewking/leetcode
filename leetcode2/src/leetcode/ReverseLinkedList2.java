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
        return reverse(head,m,n,1);
    }

    /**
     * 递归的做法，现在是这样  输入 [1,2,3,4,5] 2，4  输出：[4,3,2]
     * m,n之间反转了。
     * @param head
     * @param m
     * @param n
     * @param height
     * @return
     */
    public ListNode reverse(ListNode head,int m ,int n,int height) {
        if (head == null || head.next == null) {
            return head;
        }
        if (height >= n) {
            return head;
        }
        ListNode pNode = reverse(head.next,m,n,++height);
        if (height > m && head.next != null) {
            head.next.next = head;
            head.next = null;
        }

        return pNode;
    }

    /**
     * 1 -> 2 -> 3 -> 4 -> 5  m ： 2 n : 4
     * 1 -> 3 -> 2 -> 4 -> 5
     * 1 -> 4 -> 3 -> 2 -> 5
     * 思路：
     * 1.先来个指针移动到 m 的位置 也就是 2 然后反转
     *
     */
    public ListNode reverseBetween2(ListNode head,int m ,int n ) {
        ListNode header = new ListNode(-1);
        header.next = head;

        for (int i = 1 ; i < m ; i ++) {
            header.next = header.next.next;
        }

        // m ,n 之间需要反转的个数
        ListNode target = header;
        ListNode next = header.next.next;
        for (int i = m ; i < n ; i ++) {
            header.next.next = next.next;
            next.next = header.next;
            target.next = next;
            next = next.next;
        }
        return head;

        /**
         * ListNode dummy = new ListNode(0);
         *         dummy.next = head;
         *         ListNode pre = dummy;
         *         for(int i = 1; i < m; i++){
         *             pre = pre.next;
         *         }
         *         head = pre.next;
         *         for(int i = m; i < n; i++){
         *             ListNode nex = head.next;
         *             head.next = nex.next;
         *             nex.next = pre.next;
         *             pre.next = nex;
         *         }
         *         return dummy.next;
         */
    }

}
