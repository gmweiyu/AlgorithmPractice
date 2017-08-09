package interview;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description:
 * 找到数组中只出现一次的两个数字，其他出现两次{@link #findSingles(int[])}
 * 找到数组中只出现一次的一个数字，其他出现三次{@link #findSingle(int[])}
 */
public class Q56 {
    public static void main(String[] args) {
        int[] nums = {2, 114, 333, 8, 333, 2, 5, 5};
        int[] ans = findSingles(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findSingles(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 对整个数组进行异或操作，最终结果为两个目标数字的异或结果
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 找到异或结果中第一个1索引（这个1肯定存在，因为两个数字不相同）
        int bitMask = 1;
        while ((xor & bitMask) == 0) {
            bitMask <<= 1;
        }
        // 对原数组以当前位置的1为依据，“分割”成两个数组，分别计算
        int ans1 = 0, ans2 = 0;
        for (int num : nums) {
            // 计算当前位是否为1
            if ((num & bitMask) == 0) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        return new int[]{ans1, ans2};
    }

    private static int findSingle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 存储所有数字在32位整数中每一位出现1的次数
        int[] counts = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                // 计算当前位的数字 0或1
                int bit = num & bitMask;
                if (bit == 1) {
                    counts[i]++;
                }
                bitMask <<= 1;
            }
        }
        int ans = 0;
        // 重复数字的1出现次数能被3整除
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += (nums[i] % 3);
        }
        return ans;
    }
}
