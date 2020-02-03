package leetcode

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * Created by test
 * Date 2020/2/3 20:14
 * Description
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 

示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
 

提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyListWithRandomPointer {

    /**
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-32/
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Integer,Node> map = new HashMap<>();
        Node p = new Node(-1);
        p.next = head;
        while (p.next != null) {
            Node next = p.next;
            Node newNode = new Node(next.val);
            map.put(next.val,newNode);
            p.next = next.next;
        }
        p.next = head;
        while (p.next != null) {
            Node next = p.next;
            if (next.next != null) {
                map.get(next.val).next = map.get(next.next.val);
            }
            if (next.random != null) {
                map.get(next.val).random = map.get(next.random.val);
            }
            p.next = next.next;
        }


        return map.get(head.val);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
