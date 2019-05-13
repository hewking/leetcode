package leetcode;

import java.util.*;

/**
 *二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-13 10:23
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 **/
public class FindModeInBinarySearchTree {

    /**
     * 思路：
     * 1.参考数组求众数的方法
     * 2.BST是排好序的，要用到这个性质
     * 3.问题可以转化为求 每个子节点与根节点相等值的节点的最大值和个数
     *
     *
     */

    int max = 0;
    List<Integer> vals = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root ==null) return new int[]{};

        findM(root);
        int[] newArr = new int[vals.size()];
        for (int i = 0 ; i < newArr.length ; i ++) {
            newArr[i] = vals.get(i);
        }
        return newArr;
    }

    public void findM(TreeNode root){
        if (root == null) return;
        int num = max(root,root.val);
        if (num == max) {
            vals.add(root.val);
        } else if (num < max) {
            vals.clear();
            max = num;
            vals.add(root.val);
        }
        if (root.left != null) findM(root.left);
        if (root.right != null) findM(root.right);
    }

    public int max(TreeNode root,int value) {
        if (root == null) return 0;
        int res =0;
        if (root.val == value) {
            res ++;
        }
        res += max(root.left,value);
        res += max(root.right,value);
        return res;
    }

}
