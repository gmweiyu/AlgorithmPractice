package interview;

/**
 * Created by GuoWeiyu on 2017-05-05.
 * 二维数组中的查找
 */
public class Q4 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9},       //行列均递增
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(find(nums,7));
    }

    private static boolean find(int[][] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) return false;
        int row = 0, col = nums[0].length-1;       //行列坐标
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target)
                return true;
            else if (nums[row][col] > target)   //缩小范围查找
                col--;
            else
                row++;
        }
        return false;
    }
}
