package interview;

/**
 * Created by GuoWeiyu on 2017/08/06.
 * Description: 0 - n-1 中缺失的数字
 */
public class Q53_2 {
    public static void main(String[] args) {

    }

    private static int findTheMissing(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start=0,end= nums.length-1;
        while (start < end) {
            int mid=(start+end)/2;
            // 在mid的右边存在缺失
            if (nums[mid] == mid) {
                start=mid+1;
            }
            // nums[mid]>mid -> 在mid的左边存在缺失
            // nums[mid]<mid -> 不可能出现
            else {
                end=mid-1;
            }
        }

        return start;
    }
}
