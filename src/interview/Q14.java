package interview;

/**
 * Created by GuoWeiyu on 2017/07/26.
 * Description: 剪绳子
 */
public class Q14 {
    public static void main(String[] args) {
        System.out.println(dp(8));
    }

    /**
     * 动态规划
     */
    private static int dp(int n){
        if (n <= 3) {
            // 直接返回相应结果
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
