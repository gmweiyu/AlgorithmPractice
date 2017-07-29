package leetcode;

/**
 * Created by Weasley on 2017-03-16.
 */
public class Q33_SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    //基于二分法
    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left <= right) {
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            if (nums[mid] < nums[right]) {      //说明mid-right是有序的
                if(target>nums[mid]&&target<=nums[right])    //target在mid-right之间
                    left=mid+1;
                else
                    right=mid-1;
            }else{     //同上
                if(target>=nums[left]&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
        return -1;
    }
}
