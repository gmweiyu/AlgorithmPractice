package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Weasley on 2017-02-22.
 * 题意：保证只有一个解
 * AC
 */
public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,4};
        int target = 5;
        System.out.println(Arrays.toString(twoSum_3(nums,target)));
    }

    /**
     * 暴力解
     */
    public static int[] twoSum(int[] nums, int target){
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 遍历两次HashMap
     */
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++) {
            int complement = target-nums[i];
            // 目标元素已经存在，且不为当前元素
            if (map.containsKey(complement)&&map.get(complement)!=i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    /**
     * 遍历1次HashMap
     */
    public static int[] twoSum_3(int[] nums,int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int complement=target-nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No answer");
    }

    //算法 P119-归并+二分查找
}
