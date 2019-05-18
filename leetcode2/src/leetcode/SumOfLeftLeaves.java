package leetcode;

import leetcode.structure.TreeNode;

/**
 *左子叶之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-06 10:20
 **/
public class SumOfLeftLeaves {

    /**
     * 思路：
     * 1.看起来很简单，只需要计算左子叶
     * 2.基准情形：
     *3.叶子节点注意，这意味着不包括左子叶几点的父节点
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 左子叶节点条件
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
