package leetcode;

import leetcode.structure.TreeNode;

/**
 * 二叉树得最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-30 17:30
 **/
public class MinimumDepthOfBinaryTree {

    /**
     * 注意有一个坑得地方 [1,2]。
     * 最小深度不包括根节点，只有根节点才是1，如果有两个节点[1,2]
     * 那么2 作为叶子节点，跟跟节点组成 路径
     * 所以如果left null,最小等于 minDepth(root.right) + 1;
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) +1;
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));

    }

}
