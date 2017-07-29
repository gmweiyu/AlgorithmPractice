package interview;

/**
 * Created by GuoWeiyu on 2017-05-05.
 * 不修改数组找出重复的数字
 * <p>
 * 2,3,5,4,3,2,6,7
 */
public class Q3_2 {
    public static void main(String[] args) {
        int[] nums={2,3,5,4,3,2,6,7};
        System.out.println(duplicate(nums));
    }

    private static int duplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int start=1,end=nums.length-1;
        while (start <= end) {
            int mid=(start+end)/2;      //取中位数
            int count=count(start,mid,nums);    //小于等于中位数的数目
            if(start==end){
                if(count>1) return start;       //大于1次，说明重复
                else        break;
            }
            if(count>mid-start+1)   end=mid;    //更新区间
            else                    start=mid+1;
        }
        return -1;
    }

    //计算指定区间内的数目
    private static int count(int start,int end,int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]>=start&&nums[i]<=end)  count++;
        return count;
    }
}
