package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Weasley on 2017-04-05.
 */
public class Q90_Subsets2 {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null||nums.length==0)  return null;
        Arrays.sort(nums);
        return dfs(nums.length-1,nums);
    }

    private static int lastSize=0;

    public static List<List<Integer>> dfs(int index, int[] nums) {
        if (index == -1) {
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> t=new ArrayList<>();
            ans.add(t);
            return ans;
        }
        List<List<Integer>> ans=dfs(index-1,nums);
        int start=0;
        int size=ans.size();
        if (index > 0 && nums[index] == nums[index - 1]) {
            start=lastSize;         //如果有重复元素，则跳过前半部分
        }
        for(int i=start;i<size;i++) {
            List<Integer> t=new ArrayList<>(ans.get(i));
            t.add(nums[index]);
            ans.add(t);
        }
        lastSize=size;      //更新size
        return ans;
    }
}
