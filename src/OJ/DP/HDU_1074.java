package OJ.DP;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-22.
 */
public class HDU_1074 {
    private static int n;
    private static int[] states;
    private static int[] dp;    //当前状态最少punish
    private static String[] names;
    private static int[] deadlines,costs;
    private static int[] consumes,punishs;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n=in.nextInt();
        states=new int[1<<n];
        dp=new int[1<<n];
        names=new String[n];
        deadlines=new int[n];
        costs=new int[n];
        consumes=new int[1<<n];
        punishs=new int[1<<n];
        for(int i=0;i<n;i++) {
            names[i]=in.next();
            deadlines[i]=in.nextInt();
            costs[i]=in.nextInt();
        }
        for(int i=0;i<(1<<n);i++) {     //已有的每种状态
            for(int j=0;j<n;j++) {      //每种课程
                int state=states[i];
                if((state&(1<<j))==1)   continue;       //当前状态已经完成j课程
                int consume=consumes[state]+costs[j];
                int addition=consume-deadlines[j];
                int punish=consumes[state]+(addition>0?addition:0);
                int newState=state|(1<<j);      //计算新的状态
                if (punishs[newState] == 0||punishs[newState]>punish) {
                    consumes[newState] = consume;
                    punishs[newState] = punish;
                }
            }
        }
        System.out.println(consumes[1<<n-1]);
    }

    /*
    3
Computer 3 3
English 20 1
Math 3 2
     */
}
