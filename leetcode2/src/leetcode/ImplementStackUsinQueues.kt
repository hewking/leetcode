package leetcode

import java.util.*

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * Created by test
 * Date 2019/5/21 0:30
 * Description
 * 使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:

你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
object ImplementStackUsinQueues{

    /**
     * 思路:
     * 1.通过一个队列肯定是不行的
     * 2.思路跟通过栈实现队列差不多
     */
    class MyStack() {

        /** Initialize your data structure here. */
        val first = ArrayDeque<Int>()
        val last = ArrayDeque<Int>()

        /** Push element x onto stack. */
        fun push(x: Int) {
            first.clear()
            while (last.isNotEmpty()) {
                first.push(last.pollLast())
            }
            first.push(x)
            last.clear()
            while (first.isNotEmpty()) {
                last.push(first.pollLast())
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        fun pop(): Int {
            return last.pop()
        }

        /** Get the top element. */
        fun top(): Int {
            return last.peek()
        }

        /** Returns whether the stack is empty. */
        fun empty(): Boolean {
            return last.isEmpty()
        }

    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * var obj = MyStack()
     * obj.push(x)
     * var param_2 = obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.empty()
     */

}