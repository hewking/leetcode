package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-16 09:55
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 **/
public class NAryTreeLevelOrderTraversal {

    /**
     * 思路:
     * 1.参考二叉树的层序遍历
     * 2.怎么判断层级的开始，通过depth 和 result.size的比较
     * 3.层序list的添加 遍历 多叉节点
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        level(result,0,root);
        return result;
    }

    public void level(List<List<Integer>> result,int depth,Node root){
        if (root == null) return;
        if (result.size() == depth) {
            List<Integer> childs = new ArrayList<>();
            result.add(childs);
        }
        List<Integer> integers = result.get(depth);
        integers.add(root.val);
        for (Node node : root.children) {
            level(result,depth + 1,node);
        }
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


