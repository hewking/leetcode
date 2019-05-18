package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-07 11:24
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 **/
public class AverageOfLevelsInBinaryTree {

    /**
     * 思路:
     * 1.递归
     *  基准情形：
     *  为null 直接返回
     *  递归情形：
     *  通过递归增加深度，然后与res size进行比较是否递归的元素
     *  是同一depth ，如果是则计算平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val/1d);
        averageOfLevel(root.left,0,res);
        averageOfLevel(root.right,0,res);
        return res;
    }

    public List<Double> averageOfLevel(TreeNode root,int depth,List<Double> res) {
        if (root == null) return res;
        if (depth == res.size() -1) {
            res.add(root.val/1d);
        } else {
            Double value = res.get(res.size());
//            res.add(res.size(),);
        }
        averageOfLevel(root.left,depth + 1,res);
        averageOfLevel(root.right,depth + 1,res);
        return res;
    }

    /**
     * 迭代实现
     *  二叉树层次遍历套路，依次得到每一层的sum 然后除以个数
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int count = size;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                sum += node.val;
                size --;
            }
            res.add(sum / count);
        }
        return res;
    }

    }
