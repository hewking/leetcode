package leetcode;

import java.util.Stack;

/**
 * Created by hewking on 2016/11/30.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 */

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        if(root.left != null){
            if(root.right == null){
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        }else{
            if(root.right != null){
                return false;
            }
        }

        while(!stack.empty()){
            if(stack.size()%2 != 0) return false;
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left.val != right.val){
                return false;
            }
            if(left.left != null){
                if(right.right == null){
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            }else{
                if(right.right != null){
                    return false;
                }
            }

            if(left.right != null){
                if(right.left == null){
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            }else{
                if(right.left != null){
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isSymmetric(SymmetricTreeNode root) {
        if(root != null){
            return isSymmetricPlus(root.left,root.right);
        }
        return false;
    }

    private boolean isSymmetricPlus(SymmetricTreeNode left, SymmetricTreeNode right) {
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetricPlus(left.left,right.right)  && isSymmetricPlus(left.right,right.left);
    }
}

 class SymmetricTreeNode {
    int val;
    SymmetricTreeNode left;
    SymmetricTreeNode right;
    SymmetricTreeNode(int x) { val = x; }
}


