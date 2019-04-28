package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-28 10:21
 **/
public class MiddleOfTheLinkedList {

    /**
     * 怎么判断是中间节点？
     * 先找到节点数？ 然后再一次遍历增加数 知道节点数一半?
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int nodeCount = 0;
        ListNode target = null;
        for (ListNode node = head ; node != null ; node = node.next) {
            nodeCount ++;
        }

        int index = 0;
        for (ListNode node = head; node != null ; node = node.next) {
            if (index == nodeCount / 2) {
                target = node;
            }
            index ++;
        }
        return target;
    }

    /**
     * 输出到数组
     * 因为题干指定1-100个节点，所以可以打印所有节点到数组
     * 然后获取数组中间的节点
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int index = 0;
        while (head != null) {
            nodes[index++] = head;
            head = head.next;
        }
        return nodes[index / 2];
    }


    /**
     * 快慢指针法
     * 一个指针移动速度是另一个两倍
     * 那么快的指针到达末尾，另一个慢的则在中间
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
