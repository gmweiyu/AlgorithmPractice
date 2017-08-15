package leetcode;

/**
 * Created by Weasley on 2017-03-19.
 * http://blog.csdn.net/linhuanmars/article/details/21354751
 */
public class Q45_JumpGame2 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        // 分别记录当前步数能到达的最大step、上一步能到达的最大step
        int reach=0,lastReach=0;
        int step=0;
        for(int i=0;i<=reach&&i<nums.length;i++) {
            // 上一步数无法到达当前step，步数必须+1
            if (i > lastReach) {
                step++;
                lastReach=reach;
            }
            reach=Math.max(reach,nums[i]+i);
        }
        return step;
    }
}
