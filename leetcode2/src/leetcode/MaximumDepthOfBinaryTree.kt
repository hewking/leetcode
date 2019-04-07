package leetcode

object MaximumDepthOfBinaryTree {

    @JvmStatic
    fun main(args : Array<String>) {

    }

    fun maxDepth(root: TreeNode?): Int {
        root?:return 0
        val rightDepth = maxDepth(root?.right)
        val leftDepth = maxDepth(root?.left)
        val depth = Math.max(rightDepth,leftDepth)
        return 1 + depth
    }

}

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }