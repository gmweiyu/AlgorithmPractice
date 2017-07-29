package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-08.
 */
public class Q16_3SumClosest {
    public static void main(String[] args) {
//        int[] nums = {-1,2, 1, -4};
        int[] nums = {0, 0, 0};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }

    /**
     * 同3Sum，计算(twoSum+nums[i])-target，即
     * 3Sum与target的距离
     * 如果>0:k--
     * 如果<0:j++
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int auxDistance=2147483647;      //保存距离
        int ans=0;      //三个数的和
        for(int i=0;i<n;i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j=i+1,k=n-1;
            while (j < k) {
                int threeSum=nums[i]+nums[j]+nums[k];
                int distance=threeSum-target;
                if(distance==0)
                    return threeSum;
                else if(distance>0)
                    k--;
                else
                    j++;
                if(auxDistance>Math.abs(distance)){
                    auxDistance = Math.abs(distance);
                    ans=threeSum;
                }
            }
        }
        return ans;
    }
}
