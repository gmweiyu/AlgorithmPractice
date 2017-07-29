package leetcode;

/**
 * Created by Weasley on 2017-03-21.
 */
public class Q53_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, -2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray_2(nums));
    }

    public static int maxSubArray(int[] nums) {
        //dp[i]=x;   以nums[i]结尾的最大连续子序列和
        int[] dp=new int[nums.length+1];
        dp[1]=nums[0];
        int ans=dp[1];
        for(int i=2;i<nums.length+1;i++) {
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }

    //简洁版本
    public static int maxSubArray_2(int[] nums) {
        //f为以num[i-1]结尾的最大连续子序列的和
        int ans=Integer.MIN_VALUE,f=0;
        for(int i=0;i<nums.length;i++) {
            f=Math.max(f+nums[i],nums[i]);
            ans=Math.max(ans,f);
        }
        return ans;
    }
}
