package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @program: leetcode
 * @description: ${description}
 * @author: hewking
 * @create: 2019-04-28 09:42
 **/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca","cba"}));
    }

    /**
     * 1.最长公共前缀 和最长公共字串 有什么共同点？公共字串一般只是两个字符串对比
     * 这里是字符串数组，前缀意味着从第一个字符开始。并且遍历长度应该从字符串数组里面
     * 的长度最小的字符串长度开始遍历
     * 2.每遍历一个字符都比较是不是相等，直到遍历完成结束
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        int maxLen = strs[0].length();
        for (String str : strs) {
            maxLen = Math.min(str.length(),maxLen);
        }

        StringBuffer sb = new StringBuffer();
        char ch;
        boolean flag = false;
        for(int i = 0 ; i < maxLen ; i ++) {
            ch = strs[0].charAt(i);
            flag = true;
            for (int j = 1 ; j < strs.length ; j ++) {
                if (ch != strs[j].charAt(i)) {
                    flag = false;
                    return sb.toString();
                }
            }
            if (flag){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static boolean isValid(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

}
