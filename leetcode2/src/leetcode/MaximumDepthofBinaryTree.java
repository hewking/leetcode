package leetcode;

/**
 * Created by Administrator on 2016/9/18.
 * <p/>
 * 联系方式：。。。
 * <p/>
 * 给定一个二叉树，查找其最大深度。
 * 最大深度是沿着从根节点到最远的叶节点的最长路径的节点数
 */

/**
 *  给定一个二叉树，查找其最大深度。
 最大深度是沿着从根节点到最远的叶节点的最长路径的节点数
 */


public class MaximumDepthofBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){

    }

    public static int maxDepth(TreeNode root) {
        int depth = 0;

        return depth;
    }

    public static int traversal(TreeNode node){
        if(node == null){
            return  0;
        }else{
            int left = traversal(node.left);
            int right = traversal(node.right);
            return 1 + Math.max(left,right);
        }
    }

}
