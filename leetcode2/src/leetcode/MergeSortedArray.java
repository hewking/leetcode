package leetcode;

import java.util.Arrays;

/**
 *
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

//    public void merge(int[] nums1,int m,int[] nums2,int n) {
//         int index = 0;
//        if (nums2.length == 0 || n == 0) {
//            return;
//        }
//         if (m == 0 && nums1.length > 0) {
//             nums1[0] = nums2[0];
//         }
//         for (int i  = 0 ; i < m + index ; i ++){
//             if (nums2[index] > nums1[i]) {
//                 continue;
//             } else {
//                 // nums 移位
//                 for (int j = m + index ; j > i ; j--)  {
//                     nums1[j] =  nums1[j-1];
//                 }
//                 // 赋值nums2[index] 到 nums1
//                 nums1[i] = nums2[index];
//                 if (index < n -1) {
//                     index ++;
//                 i++;
//                 } else {
//                     return ;
//                 }

//             }
//         }

//         // 小于说明nums2还有值没有合并到nums1
//         if (index < n -1) {
//             for (int k = index,i = 0 ; k < n ; k++,i++) {
//                 nums1[index + m + i] = nums2[k];
//             }
//         }
//     }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

}
