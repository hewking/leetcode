package leetcode.structure;

/**
 * Created by test
 * Date 2019/5/18 16:04
 * Description
 */
public class TreeNode {
   public int val;
   public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void insert(int data){
        if (left == null){
            this.left = new TreeNode(data);
        } else if (right == null) {
            this.right = new TreeNode(data);
        }
    }
}
