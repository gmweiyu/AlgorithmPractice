package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Weasley on 2017-03-20.
 */
public class Q46_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        permu(nums,0);
//        permu_2(new ArrayList<>(), nums, new boolean[nums.length]);
        permu_3(nums);
    }

    //Solution 1
    private static void permu(int[] nums, int start) {
        if (start == nums.length - 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permu(nums, start + 1);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    //Solution 2
    private static void permu_2(List<Integer> list, int[] nums, boolean[] vis) {
        if (list.size() == nums.length) {
            System.out.println(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);
                permu_2(list, nums, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }

    //Solution 3  Iteration
    private static void permu_3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for (List<Integer> list : res) {               //获取当前每一个结果
                for (int pos = 0; pos <= list.size(); pos++) {     //在结果的每一个位置添加数字
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(pos, nums[i]);
                    newRes.add(new ArrayList<>(newList));
                }
            }
            res = newRes;
        }
        System.out.println(res);
    }
}
