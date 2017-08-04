package interview;

/**
 * Created by GuoWeiyu on 2017/08/04.
 * Description: 把数字翻译成字符串
 */
public class Q46 {
    public static void main(String[] args) {
        int n = 12258;
        System.out.println(translateCount(n));
    }

    private static int translateCount(int n) {
        // 数字对应的每一位字符
        char[] digits = Integer.toString(n).toCharArray();
        int length = digits.length;
        // 最终结果集
        int[] counts = new int[length];
        // 仅末位数字只能翻译成1个字符串
        counts[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            int count = counts[i + 1];

            // 计算当前数字起始的两位数是否符合要求
            int decadeDigit = digits[i] - '0';
            int unitDigit = digits[i + 1] - '0';
            int translatedNum = decadeDigit * 10 + unitDigit;
            if (translatedNum >= 10 && translatedNum <= 25) {
                if (i == length - 2) {
                    count += 1;
                } else {
                    count += counts[i + 2];
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }
}
