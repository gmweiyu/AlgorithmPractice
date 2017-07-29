package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-15.
 */
public class Q27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3,2,4,5,1,2,3,4,5,3};
        System.out.println(removeElement_3(nums,3));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int ans=0,i=0;
        while (i < nums.length) {
            if (nums[i] != val) {
                int t=nums[i];
                nums[i]=nums[ans];
                nums[ans]=t;
                ans++;
            }
            i++;
        }
        return ans;
    }

    /**
     * 简洁版本，不用保留后面的数字
     */
    public static int removeElement_2(int[] nums, int val) {
        int i=0,j=0;
        for(;j<nums.length;j++) {
            if (nums[j] != val) {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 当只有很少的元素==val时，优化版本：不能保证顺序
     */
    public static int removeElement_3(int[] nums, int val) {
        int i=0,n=nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i]=nums[n-1];
                n--;
            }else
                i++;
        }
        return n;
    }
}
