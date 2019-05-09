package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 设计HashMap
 * https://leetcode-cn.com/problems/design-hashmap/
 * Created by test
 * Date 2019/5/10 1:07
 * Description
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 */
public class DesignHashMap {

    class MyHashMap {

        public static final int DEFAULT_SIZE = 16;

        private List<Integer>[] array;

        private int size = DEFAULT_SIZE;

        private int count = 0;

        /** Initialize your data structure here. */
        public MyHashMap() {
            array = new LinkedList[size];
            for (int i = 0 ; i < size ; i ++) {
                array[i] = new LinkedList<>();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            // 扩容
            if (count > size) {
                int newSize = size * 2;
                List<Integer>[] newArray = new LinkedList[newSize];
                for (int i = 0 ; i < size ; i ++) {
                    newArray[i] = array[i];
                }
                for (int j = size ; j < newSize ;j ++) {
                    newArray[j] = new LinkedList<>();
                }
                size = newSize;
                array = newArray;
            }
            array[myHash(key)].add(0,value);
            count ++;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            List<Integer> list = array[myHash(key)];
            try{
                return list.get(0);
            } catch (Exception e) {
                return -1;
            }
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            count --;
            List<Integer> list = array[myHash(key)];
            list.clear();
        }

        private int myHash(int key){
            return key % size;
        }

        /**
         * 获取size 靠近最近的素数
         * @param size
         * @return
         */
//        private int nextPrime(int size) {
//
//        }
    }

}
