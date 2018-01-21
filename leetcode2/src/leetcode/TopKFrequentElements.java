package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    public static void main(String[] args){
        int[] test = {4,1,-1,2,-1,2,3
        };
        List<Integer> topKFrequent = topKFrequent(test,2);
        Iterator<Integer> it = topKFrequent.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> uniques = new HashMap<>();
//        uniques.put(nums[0],1);
        for(int i = 0 ; i < nums.length ; i++){
            if(uniques.get(nums[i]) == null){
                uniques.put(nums[i],1);
            }else{
                uniques.put(nums[i],uniques.get(nums[i]) + 1);
            }
        }
        Iterator it = uniques.keySet().iterator();
        List<Integer> result = new ArrayList<>();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            Integer value = uniques.get(key);
            result.add(value);
        }
        List<Integer> remeain = new ArrayList<>();
        Collections.sort(result);
        for (int i: result) {
            if(k == 0){
                break;
            }
            remeain.add(i);
            k--;
        }
        return remeain;
    }
}
