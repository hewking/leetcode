package leetcode;

/**
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * Created by test
 * Date 2019/4/27 15:25
 * Description
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 原来这就是LCA 啊 最近公共祖先。
     * 妈的 做题看那个用svg 画二叉树 看到lca还懵逼 二叉搜索树的特性就是
     * 小的在左边 大的在右边，也就是说 公共祖先一定介于p q 二者之间
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 寻找第一个满足 介于 p q 之间的节点，深度足够大也就说 足够靠近根节点
        // 等于是因为说 公共祖先可能等于自身
        // 为什么比较两次，因为没有说q,p的相对大小
        if (p.val <= root.val && q.val >= root.val || p.val >= root.val && q.val <= root
                .val) {
            return root;
        }
        return lowestCommonAncestor(p.val > root.val ? root.right : root.left,p,q);
    }

}
