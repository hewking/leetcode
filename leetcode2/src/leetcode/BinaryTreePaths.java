package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-08 09:42
 **/
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        path(root,paths,"");
        return paths;
    }

    public void path(TreeNode root,List<String> paths,String path) {
        if (isLeaf(root)) {
            path += root.val;
            paths.add(path);
        } else {
            if (root != null) {
                path += root.val + "->";
                path(root.left,paths,path);
                path(root.right,paths,path);
            }
        }
    }

    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
