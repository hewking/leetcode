package leetcode

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-17 09:42
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 **/
object SubtreeOfAnotherTree{

    @JvmStatic
    fun main(args : Array<String>) {

    }


    /**
     * 思路：
     * 1.非空
     * 2.遍历s 的每个节点，如果相等则t节点也向下移动
     */
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {

        return if(isSameTree(s,t)) {
            return true
        } else {
            isSubtree(s?.left,t).or(isSubtree(s?.right,t))
        }

    }

    // 局限性s [1,1] t[1]
//    fun isSubtree2(s : TreeNode?,t: TreeNode?) : Boolean {
//        // 都为Null
//        if (s == t) {
//            return true
//        } else if (s == null && t != null || s != null && t == null) {
//            return false
//        }
//        return if (s?.`val` != t?.`val`) {
//            isSubtree(s?.left,t).or(isSubtree(s?.right,t))
//        } else {
//            isSubtree(s?.left,t?.left).and(isSubtree(s?.right,t?.right))
//        }
//    }

    fun isSameTree(s: TreeNode? , t : TreeNode?) : Boolean{
        // 都为Null
        if (s == t) {
            return true
        } else if (s == null && t != null || s != null && t == null) {
            return false
        }
        if (s?.`val` != t?.`val`) return false
        return isSameTree(s?.left,t?.left).and(isSameTree(s?.right,t?.right))
    }

}