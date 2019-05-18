package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-14 10:05
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 **/
public class IncreasingOrderSearchTree {

    /**
     * 思路:
     * 1.中序遍历
     * 2.二叉树中序遍历
     * 然后造一棵新的树 然后按照中序遍历的顺序
     * 给新的树添加节点
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(0);
        TreeNode res1 = res;

        List<TreeNode> ans  = new ArrayList<>();
        increas(root,ans);
        for(int i=0;i<ans.size();i++)
        {
            TreeNode temp = ans.get(i);
            res.left  = null;
            res.right = temp;
            res = res.right;
        }
        res.left = null;
        return res1.right;
    }

    public void increas(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            increas(root.left,list);
            list.add(root);
            increas(root.right,list);
        }
    }

    // 不可行
//    public void increas(TreeNode root,TreeNode head) {
//        if (root ==null) return;
//
//        increas(root.left,head);
//        if (root.left == null) {
//            head.val = root.val;
//            head.right = new TreeNode(-1);
//            increas(root.right,head.right);
//        } else {
//            head.right = new TreeNode(root.val);
//            head.right.right = new TreeNode(-1);
//            increas(root.right,head.right.right);
//        }
//
//    }

}
