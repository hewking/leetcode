package leetcode

import leetcode.structure.TreeNode

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * 671. 二叉树中第二小的节点
 * Created by test
 * Date 2019/6/18 0:56
 * Description
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1:

输入:
2
/ \
2   5
/ \
5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
示例 2:

输入:
2
/ \
2   2

输出: -1
说明: 最小的值是 2, 但是不存在第二小的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object SecondMiniimumNodeInABinaryTree {

    class Solution {
        /**
         * 思路:
         * 1.因为题设子节点只有0，2两种，并且子节点大于等于父节点
         * 所以有子节点的情况下，两个子节点和父节点一共三个，必有第二大的，否则就没有
         */
        fun findSecondMinimumValue(root: TreeNode?): Int {
            var ans = -1
            if (root != null) {
                val a = root.`val`
                val b = findSecondMinimumValue(root.left)
                val c = findSecondMinimumValue(root.right)
                val arr = arrayOf(a,b,c)
                ans =
            } else {
                return  -1
            }
            return ans
        }
    }

}