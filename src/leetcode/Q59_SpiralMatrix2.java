package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-26.
 */
public class Q59_SpiralMatrix2 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    //简洁版本参考-Q54
    public static int[][] generateMatrix(int n) {
        int startX=0,endX=n-1,startY=0,endY=n-1;
        int index=1;
        int[][] ans=new int[n][n];
        while (index<=n * n) {
            for(int i=startX;i<=endX;i++)
                ans[startY][i]=index++;
            for(int i=startY+1;i<=endY;i++)
                ans[i][endX]=index++;
            for(int i=endX-1;i>=startX;i--)
                ans[endY][i]=index++;
            for(int i=endY-1;i>=startY;i--) {
                if (i == startY) {
                    startX++;
                    endX--;
                    startY++;
                    endY--;
                    break;
                }
                ans[i][startX] = index++;
            }
        }
        return ans;
    }
}
