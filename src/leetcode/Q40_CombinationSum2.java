package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Weasley on 2017-03-18.
 */
public class Q40_CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target=8;
        System.out.println(combinationSum2(candidates,target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        foo(ans,list,candidates,target,0);
        return ans;
    }

    private static void foo(List<List<Integer>> ans, List<Integer> list,
                            int[] candidates, int target,int start) {
        if(target==0){
            List<Integer> t=new ArrayList<>();
            t.addAll(list);
            Collections.sort(t);
            if(!ans.contains(t))        //过滤重复
                ans.add(t);
            return;
        }
        if(target<0)    return;
        for(int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            foo(ans,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
