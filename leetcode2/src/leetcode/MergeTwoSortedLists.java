package leetcode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-26 10:39
 **/
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    /**
     * 1.有序链表怎么生成？
     * 2.怎么利用有序链表的特点？ 跟二分有关？
     * 3.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // 做链表的题一定要考虑两个值 head cur.head用于最终结果头结点
        // cur 作递进操作

        // 往后递推l1 l2 如果长度不同会为Null
        while (l1 != null && l2 != null) {
            // 判断两个值的大小，确定cur 的指向
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        /**
         * 如果一条链null 则直接合并另一条
         */
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head.next;
    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

}
