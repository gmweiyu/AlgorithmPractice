package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Weasley on 2017-03-20.
 * 存在重复元素的全排列：[1,1,2]
 * 在从左到右遍历vis数组时，如果重复元素在前且为访问则跳过
 */
public class Q47_Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        permutaions(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private static void permutaions(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] vis) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1]) continue;
            if (!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);
                permutaions(ans, list, nums, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
