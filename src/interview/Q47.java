package interview;

/**
 * Created by GuoWeiyu on 2017/08/04.
 * Description: 礼物的最大价值
 * {@link #maxGiftsValue(int[][])}方法采用二维数组存放临时结果，Space complexity: O(N^2)
 * {@link #optimizeMaxGiftValue(int[][])}方法采用一维数组，Space complexity: O(N)
 */
public class Q47 {
    public static void main(String[] args) {
        int[][] gifts = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(maxGiftsValue(gifts));
        System.out.println(optimizeMaxGiftValue(gifts));
    }

    private static int maxGiftsValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0 || gifts[0].length == 0) {
            return 0;
        }

        int rows = gifts.length;
        int cols = gifts[0].length;

        // 到达每一个格子，当前所能拿到的礼物最大价值
        int[][] values = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 当前所取的最大价值与左、上格子有关
                int up = i > 0 ? values[i - 1][j] : 0;
                int left = j > 0 ? values[i][j - 1] : 0;
                values[i][j] = Math.max(up, left) + gifts[i][j];
            }
        }

        return values[rows - 1][cols - 1];
    }


    private static int optimizeMaxGiftValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0 || gifts[0].length == 0) {
            return 0;
        }

        int rows=gifts.length;
        int cols=gifts[0].length;
        int[] values = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left=j>0?values[j-1]:0;
                int up=i>0?values[j]:0;
                values[j]=Math.max(left,up)+gifts[i][j];
            }
        }

        return values[cols-1];
    }
}

