package leetcode


/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 * Created by test
 * Date 2019/5/28 0:22
 * Description
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。


示例：

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3


提示：

所有值都在 [1, 1000] 之内。
操作次数将在  [1, 1000] 之内。
请不要使用内置的 LinkedList 库。
 */
object DesignLinkedList{

    class MyLinkedList() {

        private var head : ListNode? = null
        private var length : Int = 0
        /** Initialize your data structure here. */
        init {
            head = ListNode(-1)
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        fun get(index: Int): Int {
            if (index >= length || index < 0) {
                return -1
            }
            var t = head
            var i = 0
            while (t != null && i <= index) {
                t = t.next
                i++
            }
            if (t != null) return t.`val`
            return -1
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        fun addAtHead(`val`: Int) {
            val node = ListNode(`val`)
            val nextNode = head?.next
            node.next = nextNode
            head?.next = node
            length++
        }

        /** Append a node of value val to the last element of the linked list. */
        fun addAtTail(`val`: Int) {
            val node = ListNode(`val`)
            var tmp = head
            while (tmp?.next != null) {
                tmp = tmp?.next
            }
            tmp?.next = node
            length++
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        fun addAtIndex(index: Int, `val`: Int) {
            if (index > length) {
                return
            }
            if (index == length) {
                addAtTail(`val`)
                return
            }
            var id = index
            if (id < 0) {
                id = index + length + 1
            }
            val node = ListNode(`val`)
            var t = head
            var i = 0
            while (t != null && i < id) {
                t = t?.next
                i ++
            }
            var n = t?.next
            t?.next = node
            node.next = n

            length++
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        fun deleteAtIndex(index: Int) {
            if (index >= length || index < 0) {
                return
            }
            var t = head
            var i = 0
            while (t != null && i < index) {
                t = t?.next
                i ++
            }
            t?.next = t?.next?.next
            length--
        }

        class ListNode(var `val` : Int){
            var next : ListNode? = null
        }

    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * var obj = MyLinkedList()
     * var param_1 = obj.get(index)
     * obj.addAtHead(`val`)
     * obj.addAtTail(`val`)
     * obj.addAtIndex(index,`val`)
     * obj.deleteAtIndex(index)
     */

}