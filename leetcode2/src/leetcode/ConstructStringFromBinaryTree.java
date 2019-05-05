package leetcode;

/**
 * Created by test
 * Date 2019/5/4 13:52
 * Description
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
public class ConstructStringFromBinaryTree {


    public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        if (t == null) {
            sb.append("()");
            return sb.toString();
        }
        sb.append(t.val);
        // 这些判断用于去除多余的括号
        if (t.left != null && t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        } else if (t.left != null) {
            sb.append("(" + tree2str(t.left) + ")");
        } else if (t.right != null) {
            sb.append("()(" + tree2str(t.right) + ")");
        }

        return sb.toString();
    }

}
