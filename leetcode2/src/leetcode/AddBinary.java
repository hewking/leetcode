package leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
//        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1","111"));
//        System.out.println(addBinary("1010","1011"));
//        System.out.println(addBinary("1111","1111"));

        System.out.println((char)(3 + '0'));
    }

    public static String addBinary(String a, String b) {
        if (!check(a) || !check(b)) {
            throw new IllegalArgumentException("参数错误");
        }
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        if (arr1.length < arr2.length) {
            char[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        int diff = arr1.length - arr2.length;
        int value = 0;
        for (int i = arr1.length - 1; i >= 0 ; i --) {
            int v1 = arr1[i] - '0';
            int v2 = 0;
            if (i - diff < 0) {
                v2 = 0;
            } else {
                v2 = arr2[i - diff] - '0';
            }
            int sum  = v1 + v2 + value;
            if (sum  > 1) {
                value = 1;
                arr1[i] = (char)((sum - 2) + '0');
            } else {
                arr1[i] = ((char) (sum + '0'));
                value = 0;
            }
        }

        if (value > 0) {
            char[] result = new char[arr1.length + 1];
            System.arraycopy(arr1,0,result,1,arr1.length);
            result[0] = '1';
            arr1 = result;
        }

        return new String(arr1);
    }

    /**
     * 非空且只包含0,1
     * @param str
     * @return
     */
    public static boolean check(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        char[] arr = str.toCharArray();
        for (int i = 0 ; i < arr.length; i ++) {
            if (arr[i] != '0' && arr[i] != '1') {
                return false;
            }
        }
        return true;
    }

}
