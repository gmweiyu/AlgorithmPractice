package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-16.
 */
public class Q34_SearchForRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target=-1;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    //基于二分法
    public static int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int start=-1,end=-1;
        while (left <= right) {
            int mid=(left+right)/2;
            if (nums[mid] == target) {
                int i=mid+1;
                while(i<=right&&nums[i]==target)
                    i++;
                end=i-1;
                i=mid-1;
                while(i>=left&&nums[i]==target)
                    i--;
                start=i+1;
                break;
            }else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return new int[]{start, end};
    }
}
