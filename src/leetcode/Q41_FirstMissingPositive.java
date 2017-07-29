package leetcode;

/**
 * Created by Weasley on 2017-03-18.
 */
public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,5,2,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        bucket_sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }

    //使用桶排序，将每个元素放置到其应该在的位置（桶）
    //如果元素为<=0，或者超出了数组范围，则break;
    private static void bucket_sort(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            while (nums[i] != i + 1) {
                if(nums[i]<=0||nums[i]>nums.length||nums[i]==nums[nums[i]-1])
                    break;
                swap(nums,i,nums[i]-1);
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
