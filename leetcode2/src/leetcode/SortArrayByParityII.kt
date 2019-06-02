package leetcode

/**
 * 922. 按奇偶排序数组 II
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * Created by test
 * Date 2019/6/3 1:27
 * Description
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。



示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。


提示：

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
 */
object SortArrayByParityII{


    class Solution {
        /**
         * 思路:
         * 1.遍历数组，偶数位如果是奇数则往后遍历找到偶数交换
         * 2.奇数同理
         */
        fun sortArrayByParityII(A: IntArray): IntArray {
            for (i in A.indices) {
                if (i % 2 == 0) {
                    if (A[i] % 2 != 0) {
                        for (j in (i + 1) until A.size) {
                            if (A[j].rem(2) == 0) {
                                val tmp = A[j]
                                A[j] = A[i]
                                A[i] = tmp
                            }
                        }
                    }
                } else {
                    if (A[i] % 2 == 0) {
                        for (j in (i + 1) until A.size) {
                            if (A[j].rem(2) != 0) {
                                val tmp = A[j]
                                A[j] = A[i]
                                A[i] = tmp
                            }
                        }
                    }
                }
            }
            return A
        }
    }

}