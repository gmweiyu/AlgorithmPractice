package interview;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 顺时针打印矩阵
 */
public class Q29 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        clockwisePrint(matrix);
    }

    /**
     * 顺时针打印matrix
     */
    private static void clockwisePrint(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int startCol = 0, endCol = matrix[0].length - 1;
        int startRow = 0, endRow = matrix.length - 1;

        // 顺时针循环遍历
        while (true) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            if (++startRow > endRow) {
                break;
            }
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            if (--endCol < startCol) {
                break;
            }
            for (int i = endCol; i >= startCol; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }
            if (--endRow < startRow) {
                break;
            }
            for (int i = endRow; i >= startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            if (++startCol > endCol) {
                break;
            }
        }
    }
}
