package leetcode;

import leetcode.structure.TreeNode;

/**
 * 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-08 11:04
 **/
public class DiameterOfBinaryTree {

    /**
     * 思路
     * 1.直径定义：任意两个节点路径长度的最大值，
     * 2.所以需要计算节点的路径长度
     * 3. 还有那个节点的路径长度比根节点出发的路径更长吗？错了，理解有误，
     * 是两个节点之间，而不是根节点到子节点，妈的 这感觉是个图的问题啊，虽说
     * 树是图的一个特列
     *
     * 唉，想多了
     * 因为我想到，子节点加上父节点的长度了，这再递归中不行的
     * 这样是父节点加子节点的
     */

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max ,leftHeight + rightHeight + 1);
        // 子节点进行判断最大长度
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return  1 + Math.max(height(root.left),height(root.right));
    }

}
