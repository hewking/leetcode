package leetcode

import leetcode.structure.TreeNode

/**
 * 783. 二叉搜索树结点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-23 09:18
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

示例：

输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

4
/   \
2      6
/ \
1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
注意：

二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object MinimumDIstanceBetweenBstNodes {

    class Solution {

        /**
         * 思路：
         * 根据二叉搜索树的性质，还有题设。相邻父子节点之间的值符合
         * 题设所要求的的值。然后所有相邻值取最小值。
         * 采用递归：
         * 1. 基线条件：子节点为null
         * 2. 递归条件：当前最小值和 父节点和两个子节点的差值，然后取最小
         *
         * 3. 二叉搜索树中序遍历 所有节点值从小到大
         */
        fun minDiffInBST(root: TreeNode?): Int {
            minDiff(root)
            return minDiffValue
        }

        private var minDiffValue: Int = Int.MAX_VALUE
        private var preNode: TreeNode? = null

        fun minDiff(root: TreeNode?) {
            root?:return
            minDiff(root?.left)
            var minVal = minDiffValue
            if (preNode != null) {
                minVal = root?.`val` - preNode!!.`val`
            }
            preNode = root
            minDiffValue = Math.min(minDiffValue,minVal)
            minDiff(root?.right)
        }
    }

}