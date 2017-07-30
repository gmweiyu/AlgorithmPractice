package interview;

/**
 * Created by GuoWeiyu on 2017/07/30.
 * Description:
 */
public class Q20 {
    private static int index = 0;

    public static void main(String[] args) {
        String string = "";
        System.out.println(match(string));
    }

    private static boolean match(String string) {
        if (string == null) {
            return false;
        }
        char[] str = string.toCharArray();

        // 1、匹配有符号整数
        boolean match = matchInteger(str);

        // 2、遇到小数点匹配其后UnsignedInt
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数点后面可以没有数字
            // 小数点前面可以没有数字
            // 小数点前后均有数字
            match = match || matchUnsignedInt(str);
        }

        // 3、遇到e/E匹配其后的指数
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // e/E前面必须有数字
            // e/E后面必须有数字
            match = match && matchInteger(str);
        }

        return match && index == str.length;
    }

    /**
     * 匹配下一个整数，如果遇到+/-前缀，向前移动index+1
     * 具体匹配逻辑交由无符号整数匹配方法{@link #matchUnsignedInt(char[])}
     */
    private static boolean matchInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return matchUnsignedInt(str);
    }

    /**
     * 匹配下一个无符号整数
     * 至少含有一个数字才能构成无符号整数
     */
    private static boolean matchUnsignedInt(char[] str) {
        int prev = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // 至少含有1个数字才能构成无符号整数
        return index > prev;
    }
}
