package leetcode

import java.util.*

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
object MinStack {


    var index = -1

    var min_ : Int = -1

    var array : IntArray = IntArray(10)

    fun push(x: Int) {
        index ++
        min_ = Math.min(x, min_)
        if (index + 1 > array.size) {
            // 扩容
            val newArr = IntArray(2 * array.size + 1)
            System.arraycopy(array, 0, newArr, 0,
                    array.size)
        }
        array[index] = x
    }

    fun pop(){
        if (index > 0) {
            index --
        }
    }

    fun top(): Int {
        return array[index]
    }

    fun getMin() : Int{
        return min_
    }



}