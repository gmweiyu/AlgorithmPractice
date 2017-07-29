package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-29.
 */
public class Q78_Subsets {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        int n=nums.length;      //n个数字
        for(int i=1;i<=n;i++){
            int[] arr=new int[i];   //一共取i个数字
            dfs(1,-1,i,arr,nums,ans);
        }
        return ans;
    }

    //整体思路与Question_77一致，但由于所取数字的集合不同（本题是特别指定，而上一题
    //的取集为1-n，所以需要记录上一次所取数字的index：即lastIndex
    public static void dfs(int index,int lastIndex, int count, int[] arr,
                           int[] nums, List<List<Integer>> ans) {
        if (index == count + 1) {
            List<Integer> list=new ArrayList<>();
            for(int i:arr)  list.add(i);
            ans.add(list);
            return;
        }
        //从lastIndex+1开始取数字
        for(int i=lastIndex+1;i<nums.length;i++){
            arr[index-1]=nums[i];
            dfs(index+1,i,count,arr,nums,ans);
        }
    }

    //逆向递归
    public static List<List<Integer>> dfs_2(int index, int[] nums) {
        if (index == -1) {      //递归的底层，取空集
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> t=new ArrayList<>();
            ans.add(t);
            return ans;
        }
        List<List<Integer>> ans=dfs_2(index-1,nums);
        int size=ans.size();        //注意：size需要写在外面
        for(int i=0;i<size;i++) {
            List<Integer> t=new ArrayList<>(ans.get(i));     //取出每一个集合，添加当前数字,注意：需要创建新对象
            t.add(nums[index]);
            ans.add(t);     //添加到结果集中
        }
        return ans;
    }
}
