package leetcode;

/**
 * Created by Administrator on 2016/11/3.
 * <p>
 * 联系方式：。。。
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args){
//        convertToBinary(123456);
//        convertToTen(1010);
//        HexToStr(16);
        convertToTitle(27);
    }

    public static String convertToTitle(int n) {
        char[] letters = new char[26];
        for(int i = 0,k = 'A';k < 'Z' + 1;k++){
            letters[i++] = (char)k;
        }
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int k = n % 26;
            n = n / 26;
            if(k == 0){
                sb.append(letters[26 - 1]);
                n--;
            }else{
                sb.append(letters[k -1]);
            }
        }

        System.out.println(sb.toString());
        return null;
    }

    public static String HexToStr(int i) {
        String s = "0123456789abcdef";
        StringBuffer sb = new StringBuffer();
        for (int j = 0; i >= 16; j++) {
            int a = i % 16;
            i /= 16;
            sb.append(s.charAt(a));
        }
        sb.append(s.charAt(i));
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }


    /**
     * 十进制转二进制
     * @param n
     * @return
     */
    public static String convertToBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int k = n % 2;
            sb.append(k);
            n = n / 2;
        }

        System.out.print(sb.reverse().toString());
        return sb.toString();
    }

    /**
     * 二进制转十进制
     */
    public static String convertToTen(int n){
        String str = n + "";
        char[] chars = str.toCharArray();
        int result =0;
        int x = 1;
        int i = chars.length - 1;
        while (true) {
            result += x * Integer.parseInt(new String(chars[i] + ""));
            x *= 2;
            i--;
            if(i < 0){
                break;
            }
        }
        System.out.println(result);

        return "";
    }
}
