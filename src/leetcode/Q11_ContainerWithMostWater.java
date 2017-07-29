package leetcode;

/**
 * Created by Weasley on 2017-03-08.
 */
public class Q11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {12,2,44,11,4,9,7,10};
        System.out.println(maxArea(height));
    }


    /**
     * 直接暴力破解，会超时
     */
    public static int maxArea(int[] height) {
        int n= height.length;
        int ans=0;

        int area=0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                area = (j - i) * Math.min(height[i], height[j]);
                if(ans<area)
                    ans=area;
            }
        }
        return ans;
    }

    /**
     * 容器的体积取决于最小的木板
     * 从数组的两边开始搜索，存储当前的最大值
     * 移动时移动较小的木板
     * Note：如果移动较大的木板，面积只会更小，不能找到新的较大体积
     */
    public static int maxArea_2(int[] height) {
        int n=height.length;
        int start=0,end=n-1;        //两个指针，初始分别指向头和尾
        int ans=-2147483648;

        while (start < end) {
            //计算当前的容器的体积
            int area = (end - start) * Math.min(height[start], height[end]);
            ans=area>ans?area:ans;

            //移动指针
            if(height[start]<=height[end])
                start++;
            else
                end--;
        }

        return ans;
    }
}
