package leetcode;

/**
 * Created by Weasley on 2017-03-16.
 */
public class Q35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

    //二分法
    public static int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left <= right) {
            int mid=(left+right)/2;
            if (target > nums[mid]) {
                left=mid+1;
            } else if (target < nums[mid]) {
                right=mid-1;
            }else
                return mid;
        }
        return left;
    }
}
