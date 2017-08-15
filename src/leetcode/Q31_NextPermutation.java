package leetcode;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/10.
 * Description: 给定某个排列，找出排列的下一个排列
 */
public class Q31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5,1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        // 从后往前找到第一个非递增的数字
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 存在非递增的数字
        if (i >= 0) {
            // 从当前位置向后找到比当前数字小的
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            j--;    // 向前回溯一个才为目标位置
            exch(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 交换后翻转后面的数字
     */
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            exch(nums, start, end);
            start++;
            end--;
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
