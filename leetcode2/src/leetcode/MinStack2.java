package leetcode;

import java.util.Stack;

/**
 * 最小栈，通过利用空间的方式。
 * 每一次入栈一个元素，紧跟当前栈的最小值入栈
 * 例如 入栈 3，1，2那么：
 * 最小栈则是  3 3 1 1 2 1
 */
public class MinStack2 {

    /** initialize your data structure here. */

    private Stack<Integer> stack = new Stack<>();

    public MinStack2() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() -2);
    }

    public int getMin() {
        return stack.peek();
    }
}
