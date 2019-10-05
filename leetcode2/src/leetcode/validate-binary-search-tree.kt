package leetcode

import leetcode.structure.TreeNode

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * Created by test
 * Date 2019/10/5 23:30
 * Description
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
2
/ \
1   3
输出: true
示例 2:

输入:
5
/ \
1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ValidateBinarySearchTree {
    class Solution {
        /**
         *  思路：
         *  1. 本题一看挺简单，通过递归可以实现。其实还有跟问题，就是
         *  所有右子树值都要比左子树及父节点都要大。
         *  2. 这里就需要个上下界限了,用于判断左右子树的上下界
         */
        fun isValidBST(root: TreeNode?): Boolean {
            return helper(root, null, null)
        }

        fun helper(root: TreeNode?, lower: Int?, upper: Int?): Boolean {
            root ?: return true
            val value = root.`val`
            val leftValid = if (lower != null) {
                value > lower
            } else true

            val rightValid = if (upper != null) {
                value < upper
            } else true

            return leftValid && rightValid && helper(root.right, value, upper) && helper(root.left, lower, value)
        }
    }
}