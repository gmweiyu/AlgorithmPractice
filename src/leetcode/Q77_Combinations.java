package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-28.
 */
public class Q77_Combinations {
    public static void main(String[] args) {
        int n=5;
        int k=3;
        System.out.println(combine(n,k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        int[] nums=new int[k+1];   //次序
        List<List<Integer>> ans=new ArrayList<>();
        dfs(ans,nums,1,n,k);        //注意起始为1
        return ans;
    }

    public static void dfs(List<List<Integer>> ans,int[] nums, int index,int n,int k) {
        if(index==k+1){
            List<Integer> list=new ArrayList<>();
            for(int i=1;i<=k;i++)   list.add(nums[i]);
            ans.add(list);
            return;
        }
        for(int i=nums[index-1]+1;i<=n;i++) {       //前一个数+1的基础上遍历
            nums[index]=i;
            dfs(ans,nums,index+1,n,k);
        }
    }
}
