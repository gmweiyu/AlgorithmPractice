package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-15.
 */
public class Q26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,4,4,5,6,6,7};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1)      return nums.length;
        int t=nums[0],i=0,ans=1;
        while (i < nums.length) {
            if (nums[i] != t) {
                t=nums[i];
                int aux=nums[ans];
                nums[ans]=nums[i];
                nums[i]=aux;
                ans++;
            }
            i++;
        }
        return ans;
    }

    /**
     * 简洁版本，不用处理已经移除的重复元素
     */
    public static int removeDuplicates_2(int[] nums) {
        if(nums.length<=1)      return nums.length;
        int i=0,j;      //Two pointers
        for(j=1;j<nums.length;j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
