package interview;

/**
 * Created by GuoWeiyu on 2017/08/03.
 * Description: 连续子数组的最大和
 */
public class Q42 {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(nums));
    }

    private static int maxSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max=0;
        int sum=0;
        for (int num : nums) {
            // 如果已有的sum<0，说明只会减少当前元素的值，重置sum为0
            if (sum < 0) {
                sum = 0;
            }
            // 计算新的sum值
            sum += num;
            max=Math.max(max,sum);
        }
        return max;
    }
}
