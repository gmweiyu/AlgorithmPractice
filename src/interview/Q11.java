package interview;

/**
 * Created by GuoWeiyu on 2017/07/25.
 * Description: 旋转数组的最小数字
 */
public class Q11 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,1};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
//        if (nums == null || nums.length == 0)
        // 找到数组的中间数字，使用二分法的思想查找
        int min = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid=(left+right)/2;
            if (nums[mid] >= nums[left]) {
                if (nums[mid] <= nums[right]) {     // 当前数组区间有序
                    return nums[left];
                } else {
                    left = mid + 1;
                    min = Math.min(nums[mid + 1], min);
                }
            } else {
                right = mid;
                min = Math.min(nums[mid], min);
            }
        }
        return min;
    }

    /**
     * 创建两个index指针，分别指向左有序数组、右有序数组
     * 最终相邻，右指针即为最小数字
     * @param nums
     * @return
     */
    private static int twoPointer(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            throw new Exception("Invalid params");
        }
        int leftPtr=0;
        int rightPtr = nums.length - 1;
        int midPtr = leftPtr;
        while (nums[leftPtr] >= nums[rightPtr]) {
            if (rightPtr - leftPtr == 1) {
                midPtr = rightPtr;
                break;
            }
            midPtr=(leftPtr+rightPtr)/2;
            // 当与左右指针均相等时，无法进行二分，则顺序查找
            if (nums[midPtr] == nums[leftPtr] && nums[midPtr] == nums[rightPtr]) {
                return findInOrder(nums, leftPtr, rightPtr);
            }
            if (nums[midPtr] >= nums[leftPtr]) {
                leftPtr=midPtr;
            } else if (nums[midPtr] <= nums[rightPtr]) {
                rightPtr=midPtr;
            }
        }
        return nums[midPtr];
    }

    // 顺序查找
    private static int findInOrder(int[] nums, int left, int right) {
        int min=left;
        for (int i = left+1; i <= right; i++) {
            min = Math.min(nums[i], min);
        }
        return min;
    }
}
