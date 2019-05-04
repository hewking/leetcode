package leetcode;

import java.util.*;

/**
 * N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * Created by test
 * Date 2019/5/4 13:06
 * Description
 */
public class AAryTreePostorderTraversal {

    /**
     * 递归做法
     * @param root
     * @return
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }

    /**
     * 迭代写法
     * 没想到跟多叉树的前序遍历查的挺大的
     * 前序要用Stack ，并且直接res.add
     *
     * 后序遍历重点 节点在最后面，先遍历
     * 且对于节点的遍历，遵循顺序，也就是队列的顺序
     * 后面节点的值需要在res 0 的位置
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> stack = new ArrayDeque<>();
        stack.add(root);
        Node tmp;
        while (!stack.isEmpty()) {
            tmp = ((ArrayDeque<Node>) stack).pop();
            res.add(0,tmp.val);
            for (int i = 0 ; i < tmp.children.size() ; i ++){
                ((ArrayDeque<Node>) stack).push(tmp.children.get(i));
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
