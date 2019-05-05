package leetcode;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-05 11:50
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 **/
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 思路：
     * 0.通过遍历数组生成树
     * 1.先生成一颗二叉搜索树
     * 2.然后再平衡
     * 这是没有利用到有序数组的做法
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        for (int num : nums) {
            insert(root,num);
        }
        // 进行平衡操作
        return root;
    }

    public void insert(TreeNode root,int num) {
        if (root == null){
            root = new TreeNode(num);
            return;
        }
        if (num > root.val) {
            insert(root.right,num);
        } else if(num < root.val){
            insert(root.left,num);
        } else {
            root.val = num;
        }

    }

    /**
     * 思路：
     * 二分查找前提也是需要有有序数组，这题很像
     * 二分查找的重要性也在于这里，用到了算法中分治的思想。很重要
     * 有序数组说明中间位置的元素可以作为BST的根节点，左边的都比它小，右边的都比它大
     *
     * 也可以说是二叉树中序遍历的逆过程，就变成了有序数组？
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) return null;
        return buildTree(nums,0,nums.length);
    }

    public TreeNode buildTree(int[] nums,int left,int right) {
        // -left 防止可能出现的溢出操作
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums,left,mid - 1);
        node.right = buildTree(nums,right,mid + 1);
        return node;
    }

}
