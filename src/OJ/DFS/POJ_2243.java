package OJ.DFS;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-21.
 */
public class POJ_2243 {
    private static int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    private static int m,n;
    private static int srcX,srcY,desX,desY;
    private static int[][] book;
    private static boolean[][] vis;
    private static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        m=in.nextInt();n=in.nextInt();
        book=new int[m][n];vis=new boolean[m][n];
        srcX=in.nextInt();srcY=in.nextInt();
        desX=in.nextInt();desY=in.nextInt();
        vis[srcX][srcY]=true;
        dfs(srcX,srcY,0);
        System.out.println(res);
    }

    private static void dfs(int x, int y,int step) {
        if (x == desX && y == desY) {
            res = Math.min(res, step);return;
        }
        for (int[] d : dir) {
            int newX=x+d[0],newY=y+d[1];
            //技巧：step>=res即可剪枝
            if(newX<0||newX>=m||newY<0||newY>=n||vis[newX][newY]||step>=res)   continue;
            vis[newX][newY]=true;
            dfs(newX,newY,step+1);
            vis[newX][newY]=false;
        }
    }
}
