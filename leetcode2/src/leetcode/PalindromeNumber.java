package leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-25 11:01
 **/
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }

    /**
     * 按照题述：
     * 1.负数不是回文数
     * 2.如果个位是0 不符合
     * 思路 ： 整数反转之后得到的如果跟之前相等就是
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return  false;
        }
        return ReverseInteger.reverse(x) == x;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 ) {
            return false;
        }

        if (x != 0 && x % 10 == 0) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return  rev == x || x == rev / 10;
    }

}
