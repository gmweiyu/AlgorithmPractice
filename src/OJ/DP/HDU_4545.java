package OJ.DP;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-24.
 */
public class HDU_4545 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        char[] src=in.nextLine().toCharArray();
        char[] des=in.nextLine().toCharArray();
        int srcM=src.length,desN=src.length;
        int n=in.nextInt();
        in.nextLine();
        char[][] table=new char[n][2];      //0-src;1-des
        for(int i=0;i<n;i++) {
            table[i]=in.nextLine().toCharArray();
        }
        boolean[][] dp = new boolean[srcM][desN];
        for(int i=0;i<srcM;i++) dp[i][0]=true;
        for(int i=1;i<desN;i++) dp[0][i]=false;
        for(int i=1;i<srcM;i++) {       //src
            for(int j=1;j<desN;j++) {   //des
                if (i >= j) {
                    boolean canChange=false;    //是否可以转换
                    for(int k=0;k<table.length;k++) {
                        if(src[i]==table[k][0]&&des[j]==table[k][1])
                            canChange=true;
                    }
                    if(src[i]==des[j])
                        canChange=true;
                    if(canChange)   dp[i][j]=dp[i-1][j]||dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[srcM-1][desN-1]);
    }
}
