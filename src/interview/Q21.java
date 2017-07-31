package interview;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/07/30.
 * Description:
 */
public class Q21 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        exchange(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = nums.length-1;
        while (left < right) {
            while (left < right && (nums[left] & 1) != 0) {
                left++;
            }
            while (left < right && (nums[--right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                internalExch(left, right, nums);
            }
        }
    }

    private static void internalExch(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
