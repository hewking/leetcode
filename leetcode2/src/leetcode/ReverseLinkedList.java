package leetcode;

import leetcode.structure.ListNode;

/**
 * Created by Administrator on 2016/9/13.
 * <p>
 * 联系方式：。。。
 */
public class ReverseLinkedList {


    public static void main(String[] args){
        ReverseLinkedList linkedList = new ReverseLinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(6);
        //1->2->3->4->5->6
        ListNode listNode = linkedList.reverseLinkedList2(linkedList.head);
        while (listNode.next!= null){
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }
    }

    ListNode head;

    ReverseLinkedList(){
        head = null;
    }

    public void push(int x){
        if(head == null){
            head = new ListNode(x);
            ListNode nextNode = new ListNode(x);
            head.next = nextNode;
            return;
        }
        ListNode listNode = new ListNode(x);
        listNode.next = head.next;
        head.next = listNode;
    }

    /**
     *
     * @param head
     * @return
     */

    /**
     * 递归的方式
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return pNode;
    }

    public ListNode reverseLinkedList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(-1);//拟一个头节点
        p.next = head;
        ListNode nextNode = head.next;
        while (nextNode != null){
            //后一个节点调整到最前
            head.next = nextNode.next;
            nextNode.next = p.next;
            p.next = nextNode;
            nextNode = head.next;
        }
        return p.next;
    }

}
