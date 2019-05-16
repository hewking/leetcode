package leetcode;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-16 11:05
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *z
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 **/
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 思路：因为所有的值存在且唯一
     * 1.这个就比BST的LCA难多了
     * 2.深度大于等于p,q的最大深度
     * 3.如果q,p有一个值等于root 则返回root
     * 4.遍历左右子树，如果都返回值则说明 root为LCA, 左右子树就是q,p ,只有第一个公共祖先会有这样的情况，左右子树q,p都找到了
     * 5.如果只是左子树返回值，则说明LCA 在左子树
     * 6.如果只是右子树返回值，则说明LCA在右子树
     * 7.都返回为 Null则没有值
     * 8.递归不是同步的，而是栈结构，所以递归的越深，值越先计算出来
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //基准情形 找p ,q
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null){
            return right;
        }

        return null;
    }


}
