package leetcode;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-10 09:38
 * 设计哈希集合
 * https://leetcode-cn.com/problems/design-hashset/
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * 思路：
 * 1.哈希表 ： 固定大小的数组 (key,value)的形式， key -> 映射为 数组下标
 * 2.hashSet value 哈希映射为Key
 *
 **/
public class DesignHashSet {

    static class MyHashSet {

        private Object PRESENT = new Object();

        private HashMap<Integer,Object> hashMap;

        /** Initialize your data structure here. */
        public MyHashSet() {
            hashMap = new HashMap<>();
        }

        public void add(int key) {
            hashMap.put(key,PRESENT);
        }

        public void remove(int key) {
            hashMap.remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return hashMap.containsKey(key);
        }

    }


}
