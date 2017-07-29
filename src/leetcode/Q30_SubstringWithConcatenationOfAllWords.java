package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-16.
 */
public class Q30_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        multiSort(nums,0,2);
    }

    public static void multiSort(int[] nums,int l,int r) {
        if(l==r)
            System.out.println(Arrays.toString(nums));
        for(int i=l;i<=r;i++) {
            exch(nums,l,i);
            multiSort(nums,l+1,r);
            exch(nums,l,i);
        }
    }

    public static void exch(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

}
