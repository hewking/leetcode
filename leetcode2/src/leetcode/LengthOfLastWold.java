package leetcode;

public class LengthOfLastWold {

    public static void main(String[] args) {

        System.out.println(solution("   hello world  "));

    }

    public static int solution(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        char ch = ' ';
        boolean flag = false;
        for (int i = 0 ; i < chars.length ; i ++) {
            ch = chars[i];

            if (!validate(ch)) {
                flag = true;
                continue;
            }

            if (flag){
                num = 0;
                flag = false;
            }

            num ++;
        }
        return num;
    }

    public static boolean validate(char ch){
        return ch <= 'z' && ch >= 'a' || ch >= 'A' && ch <= 'Z';
    }



}
