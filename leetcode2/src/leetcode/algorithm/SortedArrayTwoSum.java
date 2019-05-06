package leetcode.algorithm;

import java.util.Arrays;

/**
 * 腾讯算法题
 * 有序数组中 获取指定数等于两数之和
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-06 17:51
 **/
public class SortedArrayTwoSum {

    public static void main(String[] args) {
        int[] arr = solution(new int[]{1,2,3,4,5,7},5);
        Arrays.stream(arr).forEach(System.out::print);
    }

    /**
     * 思路:
     * 1.首先找到距离target 在数组中最近的一个数
     * 2.然后因为有序数组，比如从小到大，那么 最靠近target 的数
     * 加上从index从0 到指定index 如果等于target 则是正确的，如果没有
     * 就不是，因为从倒数第二个数开始，都比倒数第一个数相加更小
     * @param arr
     * @param target
     */
    public static int[] solution(int[] arr,int target){
        int index = 0;
        for (int num : arr) {
            if (num >= target) {
                break;
            }
            index ++;
        }

        for (int i = 0 ; i < index-1 ; i ++) {
            if (arr[i] + arr[index-1] == target) {
                return new int[]{arr[i],arr[index-1]};
            }
        }
        return new int[]{};
    }

}
