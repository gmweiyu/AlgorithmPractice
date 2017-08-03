package interview;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/03.
 * Description: 数组中出现次数超过一半的数字
 */
public class Q39 {
    public static void main(String[] args) {

    }

    /**
     * 数字间的抵消
     *
     * @param nums
     * @return
     */
    private static int find_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int ans = -1;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            // 说明当前已经完全抵消，需要赋予新的参考值
            if (times == 0) {
                ans = nums[i];
                times++;
            }
            // 已有参考值，判断增加
            else if (nums[i] == ans) {
                times++;
            } else {
                times--;
            }
        }
        return times > 0 ? ans : -1;
    }

    /**
     * 将数组排序后，超过一般的数字必定会出现在数组中间
     *
     * @param nums
     * @return
     */
    private static int find_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2 + 1];
    }
}
