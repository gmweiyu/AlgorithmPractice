package leetcode;

/**
 * Created by Weasley on 2017-03-27.
 */
public class Q69_ClimbingStairs {
    public static void main(String[] args) {
        int n=40;
        System.out.println(climbingStairs(n));
        System.out.println(fibonacci(n));
        System.out.println(dfs(0,n));
    }
    //DP;可以用Fibonacci优化空间复杂度
    public static int climbingStairs(int n){
        if(n==0||n==1)  return 1;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    //Fibonacci
    public static int fibonacci(int n){
        if(n==1)    return 1;
        int first=1,second=2;
        for(int i=3;i<=n;i++){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
    }

    //暴力解，超时;可以用记录数组优化
    public static int dfs(int step,int n){
        if(step==n) return 1;
        if(step>n)  return 0;
        return dfs(step+1,n)+dfs(step+2,n);
    }
}
