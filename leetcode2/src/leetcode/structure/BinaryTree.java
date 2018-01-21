package leetcode.structure;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<T extends Comparable> {

    public static void main(String[] args) {
        int[] arr = new int[]{32,12,543,13,21,12,4,65,223,1,23,65,3};
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int value : arr) {
            tree.insert(value);
        }

        tree.preTraverse();
        System.out.println();
        tree.middleTraverse();
        System.out.println();
        tree.behindTraverse();

        System.out.println(tree.getMaxDepth());
        System.out.println(getMaxWidth(tree));
        traverse(tree);
    }

    public BinaryTree(T data){
        this.data = data;
    }

    public BinaryTree(){

    }

    public boolean add(T value) {
        return false;
    }

    public boolean remove(T value) {
        return false;
    }

    /**
     * 获取最大深度
     *  左右子树为null 深度为1
     *  不为空 为左右深度最大值 加自身深度 既 +1
     * @return
     */
    public int getMaxDepth() {
        if (left == null && right == null) {
            return 1;
        }
        int depthLeft = 0;
        int depthRight = 0;

        if (left != null) {
            depthLeft = left.getMaxDepth();
        }

        if (right != null) {
            depthRight = right.getMaxDepth();
        }

        return Math.max(depthLeft,depthRight) + 1;

    }

    /**
     * 获取最大宽度 通过队列实现
     * 根据队列先进先出的原理
     * 内层循环结束是树一层的节点push 到队列中 此时队列size为树最大宽度
     * 再与上一层 即maxwidth 保存起来的值去最大值
     * @return
     */
    public static <R extends Comparable> int getMaxWidth(BinaryTree<R> tree){
        int maxWidth = 0;
        if (tree == null) {
            return 0;
        }

        Queue<BinaryTree<R>> queue = new ArrayDeque<>();
        queue.add(tree);
        maxWidth = 1;
        while (queue.size() > 0) {
            int len = queue.size();
            while (len > 0){
                BinaryTree<R> tempTree = queue.poll();
                len --;

                if (tempTree.left != null) {
                    queue.add(tempTree.left);
                }

                if (tempTree.right != null) {
                    queue.add(tempTree.right);
                }
            }

            maxWidth = Math.max(maxWidth,queue.size());

        }
        return maxWidth;
    }

    /**
     * 非递归实现遍历
     * 原理跟获取最大宽度一致
     */
    public static <R extends Comparable> void traverse(BinaryTree<R> tree){
        Queue<BinaryTree<R>> queue = new ArrayDeque<>();
        queue.add(tree);
        while (queue.size() > 0) {
            int len = queue.size();
            while (len > 0){
                BinaryTree<R> temp = queue.poll();
                len --;
                System.out.print(temp.data.toString() + " ");

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();

        }

    }

    // 先序遍历递归
    public void preTraverse(){
        System.out.print(data.toString() + " ");
        if (left != null) {
            left.preTraverse();
        }
        if (right != null) {
            right.preTraverse();
        }
    }

    public void middleTraverse(){
        if (left != null) {
            left.middleTraverse();
        }
        System.out.print(data.toString() + " ");
        if (right != null) {
            right.middleTraverse();
        }
    }

    public  void behindTraverse(){
        if(left != null) {
            left.behindTraverse();
        }
        if (right != null) {
            right.behindTraverse();
        }
        System.out.print(data.toString() + " ");
    }

    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public void insert(T value) {
        if (data == null) {
            this.data = value;
            return;
        }
        if (data.compareTo(value) < 0) {
            // 插入的值大于节点中的值
            if (right == null) {
                right = new BinaryTree<>(value);
            } else {
                right.insert(value);
            }
        }else if (data.compareTo(value) > 0) {
            if (left == null) {
                left = new BinaryTree<>(value);
            } else {
                left.insert(value);
            }
        }

    }



}
