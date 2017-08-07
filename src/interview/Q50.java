package interview;

/**
 * Created by GuoWeiyu on 2017/08/06.
 * Description: 第一个只出现一次的字符
 */
public class Q50 {
    public static void main(String[] args) {
        String string="abaccdeff";
        System.out.println(getFirstOnceChar(string));
    }

    private static char getFirstOnceChar(String string) {
        if (string == null || string.length() == 0) {
            return '\0';
        }

        char[] arr=string.toCharArray();

        int[] counts = new int[1 << 8];

        for (char ch : arr) {
            counts[ch]++;
        }
        for (char ch : arr) {
            if (counts[ch] == 1) {
                return ch;
            }
        }
        return '\0';
    }


}
