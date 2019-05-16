package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * Created by test
 * Date 2019/5/16 23:38
 * Description
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {

    /**
     * 思路:
     * 1.链表排序
     * 2.跟链表反转有什么关系？
     * 3.链表遍历
     * 4.冒泡？
     *
     * 正确思路：
     * O(nlogn) 必要用到分治的思想
     * 1.归并排序
     * 2.找到链表中间节点
     * 3.合并两条有序链表
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeList(head);
    }

    public ListNode mergeList(ListNode node) {
        if (node.next == null) return node;
        // 快慢指针找到 中间节点
        ListNode p = node,q = node,pre = null;
        while (p != null && p.next != null && q != null) {
            p = p.next.next;
            pre = q;
            q = q.next;
        }

        pre.next = null;
        ListNode l = mergeList(node);
        ListNode r = mergeList(q);
        return merge(l,r);
    }

    public ListNode merge(ListNode p,ListNode q) {
        ListNode cur = new ListNode(-1);
        ListNode n = cur;
        while (p != null && q != null)  {
            if (p.val < q.val) {
                n.next = p;
                p = p.next;
                n = n.next;
            } else {
                n.next = q;
                q = q.next;
                n = n.next;
            }
        }
        if (p != null) {
            n.next = p;
        }
        if (q != null) {
            n.next = q;
        }
        return cur.next;
    }
}
