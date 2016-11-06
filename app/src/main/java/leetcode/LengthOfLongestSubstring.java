package leetcode;

/**
 * Created by hewking on 2016/11/6.
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        String substr = "";
        String previousStr  = "";
        int maxLength = 1;
        for(int i = 0 ; i < s.length() ; i ++){
            for (int j = i + 1; j < s.length() ; j ++){
                substr = s.substring(i,j + 1);
                if(!subStrWithoutRepeat(substr)){
                    maxLength = Math.max(substr.length(),previousStr.length());
                    previousStr = substr;
                }
            }
        }
        return maxLength;
    }

    private static boolean subStrWithoutRepeat(String substr) {
//        int sublength = substr.length();
//        for(int i = 0 ; i < sublength ; i ++){
//            char ch = substr.charAt(i);
//            String substrLeft = substr.substring(0,i);
//            String substrRight = substr.substring(i + 1,sublength);
//            return substrLeft.contains(new String(new char[]{ch})) || substrRight.contains(new String(new char[]{ch}));
//        }

        boolean isOk = false;
        char [] tmpchar = substr.toCharArray();
        for (int i = 0; i < tmpchar.length; i++) {
            for (int j = i+1; j < tmpchar.length; j++) {
                if(tmpchar[i] == tmpchar[j]){
                    isOk = true;
                    return isOk;
                }else{
                    isOk = false;
                }
            }
        }
        return isOk;
    }
}
