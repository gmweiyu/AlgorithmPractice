package leetcode;

import java.util.*;

/**
 * Created by Weasley on 2017-03-09.
 */
public class Q18_4Sum {
    public static void main(String[] args) {
        int[] nums={-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(nums,0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++) {
            // 处理重复情况
            if(i>0&&nums[i]==nums[i-1])
                continue;

            int j=i+1,k=nums.length-1;
            while (j < k) {
                // 计算最后一个数字
                int aux=nums[i]+nums[j]+nums[k]-target;
                int auxIndex=0;
                // 查找是否含有最后一个数字
                if(j+1<k-1)
                    auxIndex = Arrays.binarySearch(nums,j+1,k-1, -aux);
                if (auxIndex >= 0) {
                   List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(-aux);
                    ans.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]) {
                        j++;
                        k--;
                    }
                } else {
                    if (aux >= 0) {
                        k--;
                    } else if (aux < 0) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 使用HashMap做缓存，存储前两个数的和及其index
     */
    public static List<List<Integer>> fourSum_2(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length<4)
            return ans;

        Arrays.sort(nums);
        int n=nums.length;

        //缓存前两个数
        Map<Integer,List<List<Integer>>> cache=new HashMap<>();
        for(int a=0;a<n;a++) {
            for (int b = a + 1; b < n; b++) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                int key=nums[a]+nums[b];        //计算key值
                List<List<Integer>> lists=cache.get(key);
                if (lists == null) {
                    lists=new ArrayList<>();
                }
                lists.add(list);
                cache.put(key, lists);      //更新key对应的缓存
            }
        }

        //计算后两个数
        for(int c=0;c<n;c++) {
            for(int d=c+1;d<n;d++) {
                int key = target - nums[c] - nums[d];

                if(cache.get(key)==null)        //不存在
                    continue;

                List<List<Integer>> lists = cache.get(key);
                for(int i=0;i<lists.size();i++) {
                    if(c<=lists.get(i).get(1))      //重复
                        continue;

                    List<Integer> list=new ArrayList<>();
                    list.add(nums[lists.get(i).get(0)]);
                    list.add(nums[lists.get(i).get(1)]);
                    list.add(nums[c]);
                    list.add(nums[d]);
                    ans.add(list);
                }
            }
        }
        //过滤重复元素
        Set<List<Integer>> set=new HashSet<>(ans);
        ans.clear();
        ans.addAll(set);
        return ans;
    }
}
