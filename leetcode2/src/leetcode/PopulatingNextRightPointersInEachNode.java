package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * Created by test
 * Date 2020/2/1 13:47
 * Description
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PopulatingNextRightPointersInEachNode {

    class Solution {
        /**
         * 思路 ：
         * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--27/
         * 结合二叉树的层级遍历
         * @param root
         * @return
         */
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                Node last = null;
                while (len > 0) {
                    Node tree = queue.poll();
                    if (tree.left != null) {
                        queue.offer(tree.left);
                    }
                    if (tree.right != null) {
                        queue.offer(tree.right);
                    }
                    if (last != null) {
                        last.next = tree;
                    }
                    last = tree;
                    len --;
                }
            }
            return root;
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
