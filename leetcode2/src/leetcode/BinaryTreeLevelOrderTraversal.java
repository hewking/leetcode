package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-16 10:16
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 **/
public class BinaryTreeLevelOrderTraversal {

    /**
     * 思路：
     * 不明白这个题为什么是中等而且我应该做过吧
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(result,0,root);
        return result;
    }

    public void level(List<List<Integer>> result,int depth,TreeNode root){
        if (root == null) return;
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        List<Integer> integers = result.get(depth);
        integers.add(root.val);
        level(result,depth+1,root.left);
        level(result,depth + 1,root.right);
    }

}
