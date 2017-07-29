package leetcode;

/**
 * Created by Weasley on 2017-03-27.
 */
public class Q64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,2,0,1},
                      {1,1,0,0},
                      {2,3,1,0}};
        System.out.println(compute(grid));
    }

    public static int compute(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];       //到达坐标i,j的最小值
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++)    dp[i][0]+=dp[i-1][0]+grid[i][0];   //第0列
        for(int j=1;j<n;j++)    dp[0][j]+=dp[0][j-1]+grid[0][j];   //第0行
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
