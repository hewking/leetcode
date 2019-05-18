package leetcode;

import leetcode.structure.TreeNode;

/**
 * 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * Created by test
 * Date 2019/5/8 0:42
 * Description
 */
public class PathSumiii {

    /**
     * 思路:
     * 1.
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return  0;
//        if (isPathSum(root,sum)) {
//            return 1 + pathSum(root.left,sum) + pathSum(root.right,sum);
//        } else {
            return pathSum(root.left,sum) + pathSum(root.right,sum) + onePath(root,sum);
//        }
    }

    public boolean isPathSum(TreeNode root , int sum) {
        if (root == null) return false;
        if (sum - root.val == 0) {
            return true;
        }
        return isPathSum(root.left,sum - root.val) || isPathSum(root.right,sum - root.val);
    }

    /**
     * 一条路径上 有多少种满足情况
     * @param root
     * @param sum
     * @return
     */
    public int onePath(TreeNode root ,int sum) {
        if (root == null) return  0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + onePath(root.left,sum) + onePath(root.right,sum);
    }

}
