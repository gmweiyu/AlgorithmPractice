package leetcode;

import java.util.Arrays;

/**
 * Created by GuoWeiyu on 2017-04-13.
 */
public class Q189_RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        rotate_2(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    //需要使用辅助数组，时间：O(n)   空间：O(n)
    public static void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)  return;
        int n=nums.length;      //数组元素总数
        int[] ans=Arrays.copyOf(nums,n);
        for(int i=0;i<n;i++) {
            nums[(i+k)%n]=ans[i];
        }
    }

    //使用辅助元素记录并交换，时间：O(n)   空间：O(1)
    public static void rotate_2(int[] nums, int k) {
        int n=nums.length;
        k%=n;       //处理重复旋转
        int count=0;        //当前已经交换了几个数字
        for(int start=0;count<n;start++) {
            int current=start;
            int prev=nums[start];
            do {
                int next=(current+k)%n;     //计算对应的下一个数字
                int temp=nums[next];        //缓存下一数字的值
                nums[next]=prev;            //交换当前数字到一下数字
                prev=temp;
                current=next;
                count++;
            }while(start!=current);
        }
    }
}
