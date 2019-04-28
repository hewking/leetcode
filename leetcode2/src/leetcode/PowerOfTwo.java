package leetcode;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 * Created by test
 * Date 2019/4/27 14:56
 * Description
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }

    /**
     * 1 . 当然是 二的零次方
     * 2.
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 1) {
            int val = n % 2 ;
            n = n / 2;
            if (val != 0) {
                return false;
            }

        }
        return  true;
    }

    /**
     * 二进制的方式
     * 1.2的幂说明转化为二进制都是0，1的组合，且只有一个1 比如8  00001000
     * 负数在二进制下为补码（原码按位取反(0->1 1->0) 再加1）
     * 不如 -8 11111000  -8 & 8 = 8 这样可得。
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo2(int num){
        return num >= 0 && (num & (-num)) == num;
    }

}
