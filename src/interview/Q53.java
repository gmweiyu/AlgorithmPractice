package interview;

/**
 * Created by GuoWeiyu on 2017/08/06.
 * Description: 在排序数组中查找数字出现的次数
 */
public class Q53 {
    public static void main(String[] args) {

    }

    private static int count(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int firstN = getFirstN(nums, n);
        int lastN = getLastN(nums, n);

        if (firstN != -1 && lastN != -1) {
            return lastN - firstN + 1;
        } else {
            return 0;
        }
    }

    /**
     * 使用二分法找到数组中n第一次出现的index
     *
     * @param n
     * @return
     */
    private static int getFirstN(int[] nums, int n) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (n == nums[mid]) {
                // 如果当前n的左边数字不为n，说明当前n是第一次出现
                if (mid == 0 || nums[mid - 1] != n) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (n > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static int getLastN(int[] nums, int n) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (n == nums[mid]) {
                if (n == nums.length - 1 || nums[mid + 1] != n) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (n > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
