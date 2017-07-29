package leetcode;

/**
 * Created by Weasley on 2017-03-18.
 */
public class Q42_TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2,1,0,2};
        System.out.println(trap(height));
    }

    /**
     * 先扫描一遍，找出最大的柱子max，将数组分成两半
     * 从前至max、从后至max分别扫描，不断寻找peak，小于peak则可以装水
     */
    public static int trap(int[] height) {
        int ans=0,max=0;
        for(int i=0;i<height.length;i++)
            if(height[i]>height[max])
                max=i;
        for(int i=0,peak=0;i<max;i++) {
            if(height[i]>peak)      peak=height[i];
            else                    ans+=peak-height[i];
        }
        for(int i=height.length-1,peak=0;i>max;i--) {
            if(height[i]>peak)      peak=height[i];
            else                    ans+=peak-height[i];
        }
        return ans;
    }
}
