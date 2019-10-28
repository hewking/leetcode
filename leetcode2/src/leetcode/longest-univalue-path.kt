package leetcode

import leetcode.structure.TreeNode

/**
 * 687. 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-25 10:36
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

注意：两个节点之间的路径长度由它们之间的边数表示。

示例 1:

输入:

5
/ \
4   5
/ \   \
1   1   5
输出:

2
示例 2:

输入:

1
/ \
4   5
/ \   \
4   4   5
输出:

2
注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-univalue-path
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object LongestUnivaluePath {

    class Solution {

        private var ans = 0

        /**
         * 思路：
         * 1. 递归情形：有左右节点，并且子节点的值跟root.value 做判断
         * 2. 基准情形：root == null
         *
         *  /**
        解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
        1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
        2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
        需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
        **/
         */
        fun longestUnivaluePath(root: TreeNode?): Int {
            root?:return 0
            arrowLength(root)
           return ans
        }

        fun arrowLength(root: TreeNode?): Int {
            root?:return 0
            val leftLen = arrowLength(root?.left)
            val rightLen = arrowLength(root?.right)
            val leftUniValue = if (root.left != null && root.left.`val` == root.`val`) 1 + leftLen else 0
            val rightUniValue = if (root.right != null && root.right.`val` == root.`val`) 1 + rightLen else 0
            // leftLen + rightLen 因为最长通值路径可以不经过根节点
            ans = Math.max(ans,leftUniValue + rightUniValue)
            return Math.max(leftUniValue,rightUniValue)
        }
    }

}