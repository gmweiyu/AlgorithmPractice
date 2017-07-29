package leetcode;

/**
 * Created by Weasley on 2017-03-19.
 */
public class Q55_JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1, 1};
        System.out.println(canJump_2(nums));
    }
    //贪心：一层一层往上跳，并更新reach(能够到达的层数)
    public static boolean canJump(int[] nums) {
        int reach=0;        //初始最多达到第0层
        for(int i=0;i<=reach&&reach<nums.length-1;i++) {
            reach=Math.max(reach,i+nums[i]);        //更新最大层数
        }
        return reach>=nums.length-1;
    }

    //贪心：反向，从上往下
    public static boolean canJump_2(int[] nums) {
        int reach=nums.length-1;
        for(int i=nums.length-1-1;i>=0;i--) {       //从倒数第二层开始，遍历至第0层
            if(nums[i]+i>=reach)
                reach=i;
        }
        return reach==0;
    }
}
