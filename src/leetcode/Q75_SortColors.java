package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-28.
 */
public class Q75_SortColors {
    public static void main(String[] args) {
        int[] nums={0,0,1,0,2,0,1,2,0,2,1};
        sortColors_3(nums);
        System.out.println(Arrays.toString(nums));
    }

    //找到每种颜色的个数
    public static void sortColors(int[] nums) {
        int[] counts=new int[3];    //对应三种颜色的数目
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0)  counts[0]++;
            else if(nums[i]==1) counts[1]++;
            else            counts[2]++;
        }
        int index=0;
        for(int i=0;i<counts[0];i++)    nums[index++]=0;
        for(int i=0;i<counts[1];i++)    nums[index++]=1;
        for(int i=0;i<counts[2];i++)    nums[index++]=2;
    }

    //先整合颜色0，再整合颜色1，剩余的即颜色2
    public static void sortColors_2(int[] nums) {
        int index=0,i=0,n=nums.length;
        while (index < n) {
            if(nums[index]==0)    exch(nums,index,i++);
            index++;
        }
        index=i;
        while(index<n){
            if(nums[index]==1)    exch(nums,index,i++);
            index++;
        }
    }

    //颜色0交换到首、颜色2交换为尾、颜色1不变，即中间
    public static void sortColors_3(int[] nums) {
        int n=nums.length,left=0,right=n-1,index=0;
        while (index < n) {
            if(nums[index]==0&&index>left)      exch(nums,left++,index);
            else if(nums[index]==2&&index<right) exch(nums,right--,index);
            else index++;
        }
    }

    private static void exch(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
