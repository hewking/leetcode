package leetcode;

import leetcode.structure.TreeNode;

/**
 * 单值二叉树
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-06 10:01
 **/
public class UnivaluedBinaryTree {

    /**
     * 思路：
     * 1.采用递归的方式
     * 2.基准情形是 如果
     */
    public boolean isUnivalTree(TreeNode root) {
        boolean isUnival = false;
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        } else if(root.left == null) {
            isUnival = root.val == root.right.val;
        } else if (root.right == null) {
            isUnival = root.val == root.left.val;
        } else {
            isUnival = root.val == root.left.val && root.val == root.right.val;
        }
        return isUnival && isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
