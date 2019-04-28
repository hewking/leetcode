package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Created by test
 * Date 2019/4/29 0:11
 * Description
 */
public class PalindromeLinkedList {

    /**
     * 1.指定两个指针 一个指向头结点，一个尾结点 然后依次向前
     *
     * 或者利用快慢指针法 找到中间结点 然后反转 后半部分
     * 然后对比前半部分是否相同
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode header = new ListNode(-1);
        header.next = head;
        // 这里的判断条件为什么是 fast.next.next ? 要想一想
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode  p = reverse(slow.next);
        if (p == null) return false;
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return pNode;
    }

}
