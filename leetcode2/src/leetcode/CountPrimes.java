package leetcode;

/**
 * https://leetcode-cn.com/problems/count-primes/
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-05-10 19:06
 **/
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2 ; i < n ; i ++) {
            if (isPrime(i)){
                count ++;
            }
        }
        return count;
    }

    public boolean isPrime(int num) {
        if (num == 2) return true;
        int m = num / 2;
        for (int i = 2 ;i  < m + 1; i ++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
