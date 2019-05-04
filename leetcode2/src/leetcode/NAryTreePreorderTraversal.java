package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by test
 * Date 2019/5/4 10:36
 * Description
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * N叉术的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class NAryTreePreorderTraversal {

    List<Integer> resultes = new ArrayList<>();

    /**
     * 递归的解决办法
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return resultes;
        resultes.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return resultes;
    }

    /**
     * 1.递归法和迭代法之间可以相互转换，迭代法一般都是比较难的
     * 递归是通过栈实现的，所以一般递归转迭代都可以用栈来实现
     * 思路：
     * 用stack来模拟每一次递归
     * 1.前序遍历就是 先把值压入栈中，然后再遍历
     * 2.而且递归总是伴随着while循环 条件一般是一个为null 和这empty 还有一个tmp 临时变量
     * 存储中间值，这个值是递归返回的，状态或者值报错
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null)  return nums;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node tmp ;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            nums.add(tmp.val);
            for (int j = tmp.children.size() -1 ; j >= 0 ; j--) {
                stack.push(tmp.children.get(j));
            }

        }
        return  nums;
    }


        class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
