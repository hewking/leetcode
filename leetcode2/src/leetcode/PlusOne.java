package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public static void main(String[] args) {
        int [] arr = plusOne2(new int[]{9,8});
        Arrays.stream(arr).forEach(i ->{
            System.out.print(i);
        });
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int value = 1;
        int[] digitsResult = new int[len + 1];
        for (int i = len ; i > 0 ; i --) {
            int j = i - 1;
            int num = digits[j];
            value += num;
            if (value > 9) {
                digitsResult[i] = 0;
                value = 1;
            } else {
                digitsResult[i] = value;
                value = 0;
            }
        }

        if (value > 0) {
            digitsResult[0] = 1;
        } else {
            int[] arr = new int[len];
            for (int j = digitsResult.length - 1; j > 0; j--) {
                arr[j-1] = digitsResult[j];
            }
            digitsResult = arr;
        }

        return digitsResult;
    }

    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        int value = 1;
        for (int i = len - 1 ; i >= 0 ; i --) {
            int num = digits[i];
            value += num;
            if (value > 9) {
                digits[i] = 0;
                value = 1;
            } else {
                digits[i] = value;
                value = 0;
            }
        }

        if (value > 0) {
            int[] copy = new int[len + 1];
            System.arraycopy(digits, 0, copy, 1,
                   len);
            copy[0] = 1;
            digits = copy;
        }

        return digits;
    }

}
