package interview;

/**
 * Created by GuoWeiyu on 2017-05-05.
 * 数组中重复的数字
 *
 * 2,3,1,0,2,5,3    2或3重复
 */
public class Q3_1 {
    public static void main(String[] args) {
        int[] nums={2,3,1,0,2,5,3};
        duplicate(nums);
    }

    private static void duplicate(int[] nums) {
        if(nums==null||nums.length==0)  return;     //两种非法输入
        for(int i=0;i<nums.length;i++)
            if(nums[i]<0||nums[i]>nums.length-1)    return;

        for(int i=0;i<nums.length;i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {     //正确的位置已经有正确的数字，则重复
                    System.out.println(nums[i]);
                    break;
                }
                int t=nums[i];      //交换到正确的位置
                nums[i]=nums[t];
                nums[t]=t;
            }
        }
    }
}
