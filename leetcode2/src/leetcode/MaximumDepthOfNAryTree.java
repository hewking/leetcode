package leetcode;

import java.util.List;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-13 10:11
 * 多叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 **/
public class MaximumDepthOfNAryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        int max = 0;
        for (Node node : children) {
            max = Math.max(max,maxDepth(node));
        }
        return  1 + max;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
