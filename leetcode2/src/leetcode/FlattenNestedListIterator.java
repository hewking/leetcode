package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * Created by test
 * Date 2020/2/2 16:32
 * Description
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 1. 跟栈相关，入栈
 *
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private List<Integer> mList;
    private int size;
    private int curIndex;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.mList = new ArrayList<>();
        this.fillData(nestedList);
        this.size = this.mList.size();
        this.curIndex = 0;
    }

    private void fillData(List<NestedInteger> nestedList){
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                mList.add(ni.getInteger());
            } else {
                fillData(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return mList.get(curIndex++);
    }

    @Override
    public boolean hasNext() {
        return curIndex < size;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}


