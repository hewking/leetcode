package leetcode;

import java.util.Arrays;

/**https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 *
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * Created by test
 * Date 2019/4/27 14:13
 * Description
 */
public class ReverseWordsInAString_3 {

    public static void main(String[] args) {
        System.out.println(reverswWords2("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        Arrays.stream(words).forEach(word -> {
            sb.append(new StringBuilder(word).reverse().toString());
            sb.append(" ");
        });
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static String reverswWords2(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int begin = 0;
//        reverse(arr,6,10);
        for (int i= 0 ; i < len ; i ++) {
            if (arr[i] == ' ') {
                // 反转begin 到 空格处的char
                reverse(arr,begin,i);
                begin = i + 1;
            }
        }
        reverse(arr,begin,len - 1);
        return new String(arr);
    }

    /**
     * 反转指定char数组 ，指定位置到末尾位置的char
     * @param chars
     * @param begin
     * @param end
     */
    public static void reverse(char[] chars,int begin , int end) {
        int len = end - begin;
        for (int i = begin ; i  < begin + len / 2 ; i ++) {
            char tmp = chars[i];
            chars[i] = chars[end - i - 1 + begin];
            chars[end - i - 1 + begin] = tmp;
        }
    }

}
