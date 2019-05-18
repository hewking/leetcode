package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-30 10:19
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 **/
public class BinaryTreeInorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        travsersal(root);
        return list;
    }

    public void travsersal(TreeNode node) {
        if (node != null) {
            travsersal(node.left);
            list.add(node.val);
            travsersal(node.right);
        }
    }

}
