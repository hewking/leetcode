package leetcode

import java.util.*

/**
 *
232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * Created by test
 * Date 2019/5/21 0:12
 * Description
 * 使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
示例:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
说明:

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
object ImplementOueueUsingStacks {

    /**
     * 思路：
     * 1.一个栈肯定是不行的，需要用到两个栈
     * 2.
     */
    class MyQueue() {

        /** Initialize your data structure here. */
        val first = Stack<Int>()
        val last = Stack<Int>()

        /** Push element x to the back of queue. */
        fun push(x: Int) {
            first.clear()
            while (last.isNotEmpty()) {
                first.push(last.pop())
            }
            first.push(x)
            last.clear()
            while (first.isNotEmpty()) {
                last.push(first.pop())
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        fun pop(): Int {
            return last.pop()
        }

        /** Get the front element. */
        fun peek(): Int {
            return last.peek()
        }

        /** Returns whether the queue is empty. */
        fun empty(): Boolean {
            return last.isEmpty()
        }

    }

}