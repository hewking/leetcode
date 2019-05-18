package leetcode;

import leetcode.structure.TreeNode;

/**
 * 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * Created by test
 * Date 2019/5/8 0:15
 * Description
 */
public class PathSum {

    /**
     * 思路:
     * 1.审题，根节点到叶子节点路径之和
     * 2.怎么判断是叶子节点？
     * 之和？说明子节点往下加root.value == sum
     * 所以递归 需要sum - root.val
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

}
