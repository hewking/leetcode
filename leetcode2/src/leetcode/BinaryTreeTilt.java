package leetcode;

/**
 * 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 *
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 *
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-09 10:11
 **/
public class BinaryTreeTilt {

    /**
     * 思路：
     * 1.树的坡度是所有节点坡度之和，说明是要遍历每个节点坡度然后相加
     * 2.求每个节点坡度，左右子树和之差绝对值
     * <p>
     * 这种方式缺点，求子节点的和重复计算太多次
     */
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null && root.right != null) {
            val = Math.abs(sumOfNodes(root.left) - sumOfNodes(root.right));
        } else if (root.left != null) {
            val = Math.abs(sumOfNodes(root.left));
        } else if (root.right != null) {
            val = Math.abs(sumOfNodes(root.right));
        }
        return val + findTilt(root.left) + findTilt(root.right);
    }

    public int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }


    /**
     * 第二种方式
     * 其实对于这种类型有套路的，跟之前的二叉树直径一样，因为
     * 需要比较每个节点的坡度，然后求最大值，所以这个值需要保留起来
     * 然后再一次遍历每个节点
     *
     * @param root
     * @return
     */

    int sum = 0;

    public int findTilt2(TreeNode root) {
        add(root);
        return sum;
    }

    public int add(TreeNode root){
        if (root == null) return 0;
        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);
        sum += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
    }
}
