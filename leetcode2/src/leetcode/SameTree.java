package leetcode;

import leetcode.structure.TreeNode;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-30 09:41
 * https://leetcode-cn.com/problems/same-tree/
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 **/
public class SameTree {

    /**
     * 肯定是要遍历两棵树的
     * 1.递归的方式 中序遍历
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if (p != null && q != null) {
            return q.val == p.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

    /**
     * 非递归方法求解
     * public boolean isSameTree(TreeNode p, TreeNode q) {
     *     Stack<TreeNode> stack = new Stack<>();
     *     stack.push(p);
     *     stack.push(q);
     *     while(stack.size() > 0) {
     *         TreeNode n1 = stack.pop();
     *         TreeNode n2 = stack.pop();
     *         if (n1 == null && n2 == null) {
     *             continue;
     *         } else if(n1 == null || n2 == null) {
     *             return false;
     *         } else if(n1.val == n2.val) {
     *             stack.push(n1.right);
     *             stack.push(n2.right);
     *             stack.push(n1.left);
     *             stack.push(n2.left);
     *         } else {
     *             return false;
     *         }
     *     }
     *     return true;
     * }
     */

}
