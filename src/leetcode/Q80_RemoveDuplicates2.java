package leetcode;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q80_RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==0)  return 0;
        int i=0,j=1,times=1;        //i记录答案的个数，j是搜索索引
        for(;j<nums.length;j++) {
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                times=1;    //重置出现次数为1
            }else{
                times++;
                if(times<=2){
                    i++;
                    nums[i]=nums[j];
                }
            }
        }
        return i+1;     //索引+1
    }
}
