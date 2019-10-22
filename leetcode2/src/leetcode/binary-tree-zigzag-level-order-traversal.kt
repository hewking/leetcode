package leetcode

import leetcode.structure.TreeNode
import java.util.*

/**
 * 103. 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-22 10:43
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
返回锯齿形层次遍历如下：

[
[3],
[20,9],
[15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
object BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root?: return mutableListOf()
        val list = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        var isLeft = true
        while (queue.size > 0) {
            var len = queue.size
            val values = mutableListOf<Int>()
            while (len > 0) {
                val node = queue.poll()
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
                len --
                values.add(node!!.`val`)
            }
            if (!isLeft) {
                values.reverse()
            }
            list.add(values)
            isLeft = !isLeft
        }
        return list
    }
}