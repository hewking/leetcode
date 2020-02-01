package leetcode

import leetcode.structure.TreeNode

/**
 *
105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Created by test
 * Date 2020/2/1 13:14
 * Description
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

3
/ \
9  20
/  \
15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ConstructBinaryTreeFromPreorderAndInOrderTraversal {

    /**
     * 思路：
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
     */
    class Solution {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            return buildTreeHelper(preorder,0,preorder.size,inorder,0,inorder.size)
        }

        fun buildTreeHelper(preorder: IntArray,pStart:Int,pEnd:Int,inorder: IntArray,iStart:Int,iEnd:Int):TreeNode? {
            if (pStart == pEnd) {
                return null
            }
            val rootValue = preorder[pStart]
            val root = TreeNode(rootValue)
            var rootIndex = 0
            for (i in iStart until iEnd) {
                if (rootValue == inorder[i]) {
                    rootIndex = i
                    break
                }
            }
            val leftNum = rootIndex - iStart
            root.left = buildTreeHelper(preorder,pStart + 1,pStart + leftNum + 1,inorder,iStart,rootIndex)
            root.right = buildTreeHelper(preorder,pStart + leftNum + 1,pEnd,inorder,rootIndex + 1,iEnd)
            return root
        }
    }

}