package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * Created by test
 * Date 2019/4/30 0:53
 * Description
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 1.排序链表 假设从小到大
     * 如果head ,head.next 相等 则移除next节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode next = head.next;

        while (head != null && next != null) {
            if (head.val == next.val) {
                head.next = next.next;
                next = head.next;
            } else {
                head = head.next;
                next = head.next;
            }
        }
        return p.next;
    }

}
