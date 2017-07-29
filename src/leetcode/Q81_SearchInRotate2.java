package leetcode;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q81_SearchInRotate2 {
    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)  return false;
        int left=0,right=nums.length-1,mid;
        while (left <= right) {
            mid=(left+right)/2;
            if(target==nums[mid])   return true;
            if (nums[mid] > nums[left]) {       //左半边有序
                if(target>=nums[left]&&target<=nums[mid])   right=mid-1;
                else    left=mid+1;
            } else if (nums[mid] < nums[left]) {    //右半边有序
                if (target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {    //nums[mid]==nums[left]
                left++;     //直到遇到不相等的nums[left]
            }
        }
        return false;
    }
}
