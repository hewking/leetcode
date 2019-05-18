package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-05 09:49
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 **/
public class BinaryTreeLevelOrderTraversal2 {


    /**
     * 思路：
     * 1.从后往前层次遍历 res.add(0,list) 就可以
     * 2.怎么遍历每一层？
     * 需要一个值depth 深度，通过递归判断深度，然后确定节点
     * 再同一层，然后添加数据
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        levelOrderRecursion(res,root,0);
        return res;
    }

    public void levelOrderRecursion(List<List<Integer>> res ,TreeNode root ,int depth){
        if (root == null) return;
        if (depth == res.size()) {
            res.add(0,new ArrayList<>());
        }
        res.get(res.size() - depth - 1).add(root.val);
        levelOrderRecursion(res,root.left,depth + 1);
        levelOrderRecursion(res,root.right,depth + 1);
    }

}
