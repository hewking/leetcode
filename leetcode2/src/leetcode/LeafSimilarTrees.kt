package leetcode

import leetcode.structure.TreeNode
import java.util.*

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * Created by test
 * Date 2019/5/29 1:09
 * Description
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。



提示：

给定的两颗树可能会有 1 到 100 个结点。
 */
object LeafSimilarTrees{

    /**
     * 思路：
     * 1.中序遍历叶子节点
     * 2.然后对比
     */
    class Solution {
        fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
            val list1 = mutableListOf<Int>()
            val list2 = mutableListOf<Int>()
            travsel(root1,list1)
            travsel(root2,list2)
            if (list1.size != list2.size) return false
            for (i in list1.indices) {
                if (list1[i] != list2[i]) return false
            }
            return true
        }


        fun travsel(root : TreeNode?,list : MutableList<Int>){
            if (root == null) return
            if (root?.left == null && root?.right == null){
                list.add(root?.`val`)
            }
            travsel(root?.left,list)
            travsel(root?.right,list)
        }
    }

}