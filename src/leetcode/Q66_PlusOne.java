package leetcode;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/11.
 * Description: https://leetcode.com/problems/plus-one/description/
 */
public class Q66_PlusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9};
        int[] ans = plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null||digits.length==0) {
            return digits;
        }
        // 模拟加法
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int digit=digits[i]+carry;
            digits[i]=digit%10;
            carry=digit/10;
            // 不产生进位时，退出
            if (carry == 0) {
                return digits;
            }
        }
        // 当且仅当最高位产生进位1
        int[] ans = new int[digits.length + 1];
        ans[0]=1;
        return ans;
    }
}
