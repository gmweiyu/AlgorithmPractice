package leetcode;

/**
 * Created by Weasley on 2017-03-26.
 */
public class Q63_UniquePaths2 {
    public static void main(String[] args) {

    }

    //动态规划，同样可以用UniquePaths的方法优化空间复杂度
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] book=new int[m][n];
        book[0][0]=1-obstacleGrid[0][0];
        for(int i=1;i<m;i++)    book[i][0]=obstacleGrid[i][0]==1?0:book[i-1][0];
        for(int j=1;j<n;j++)    book[0][j]=obstacleGrid[0][j]==1?0:book[0][j-1];
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                book[i][j]=obstacleGrid[i][j]==1?0:book[i-1][j]+book[i][j-1];
            }
        }
        return book[m-1][n-1];
    }
}
