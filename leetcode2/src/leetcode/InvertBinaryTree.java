package leetcode;

import leetcode.structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-30 17:48
 * 这个题牛逼了，大佬面试google 都搞不定 要是我搞定了 哈哈 服一下自己
 **/
public class InvertBinaryTree {

    /**
     * 这个题一看就跟 对称二叉树差不多。
     * 思路：
     * 1.重点在于递归
     * 2. 在于对每个字数的翻转？
     * 怎么翻转 tmp = root.left;
     * root.left = root.right;
     * root.right = tmp
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
