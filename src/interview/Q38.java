package interview;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017/08/03.
 * Description: 全排列
 */
public class Q38 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int start = 0;

        permutations(start, nums);
    }

    private static void permutations(int start, int[] nums) {
        if (start == nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(i, start, nums);
            permutations(start + 1, nums);
            swap(i, start, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
