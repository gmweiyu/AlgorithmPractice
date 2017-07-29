package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-17.
 */
public class Q39_CombinationSum {
    public static void main(String[] args) {
//        int[] candidates={92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
//        int target=310;
        int[] candidates = {2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        foo(ans,list,candidates,target,0);
        return ans;
    }

    private static void foo(List<List<Integer>> ans,List<Integer> list,int[] candidates, int target,int start) {
        if(target==0){
            List<Integer> t=new ArrayList<>();
            t.addAll(list);
            ans.add(t);
            return;
        }
        else if(target<0)       //剪枝，或者在循环内部进行：if(target<candidates[i])     return;
            return;
        //从start标记位开始，可以避免重复，进而省去排序操作
        for(int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            foo(ans, list, candidates, target - candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
