package interview;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description: 和为s的两个数字（递增排序）
 */
public class Q57 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        int target = 15;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 分别指向数组的头、尾，向中间遍历
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                return new int[]{nums[head], nums[tail]};
            }
            // 说明nums[tail]太大，应该向左移动
            else if (sum > target) {
                tail--;
            }
            // 说明nums[tail]太小，应该向右移动
            else {
                head++;
            }
        }
        // 不存在
        return null;
    }
}
