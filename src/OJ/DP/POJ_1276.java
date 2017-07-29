package OJ.DP;

import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-26.
 * 多重背包
 */
public class POJ_1276 {

    private static int n;       //n对硬币
    private static int[] vals,nums;
    private static int m;       //最大价值
    private static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        vals=new int[n];nums=new int[n];
        for(int i=0;i<n;i++) {
            vals[i]=in.nextInt();nums[i]=in.nextInt();
        }
        dp=new int[m+1];
//        for(int i=1;i<=m;i++)         //必须装满
//            dp[i]=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            multi(vals[i],nums[i],m);
        }
        System.out.println(dp[m]);
    }

    //多重背包
    private static void zeroOne(int val){
        for(int v=m;v>=val;v--) {
            dp[v]=Math.max(dp[v],dp[v-val]+val);
        }
    }

    //完全背包
    private static void complete(int val){
        for(int v=val;v<=m;v++){
            dp[v]=Math.max(dp[v],dp[v-val]+val);
        }
    }

    //多重背包
    private static void multi(int val,int num,int max){
        if (val * num >= max) {
            complete(val);
            return;
        }
        int k=1;
        while (k < num) {
            zeroOne(k*val);
            num-=k;
            k*=2;
        }
        zeroOne(val*num);
    }
}
