package leetcode;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017-05-08.
 */
public class Q480_SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums,k)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double[] res=new double[n-k+1];
        for(int i=0;i<n-k+1;i++) {
            res[i]=findMedian(i,k,nums);
        }
        return res;
    }

    private static double findMedian(int start,int k,int[] nums){
        int[] temp= Arrays.copyOfRange(nums,start,start+k);
        if (k % 2 != 0) {
            Arrays.sort(temp);
            return temp[k/2];
        }
        int a=temp[k/2-1];
        int b=temp[k/2];
        return (a+b)/2.0;
    }
}
