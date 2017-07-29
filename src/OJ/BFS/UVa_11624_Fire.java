package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-21.
 * http://blog.csdn.net/u013480600/article/details/25233479
 */
public class UVa_11624_Fire {
    private static int m,n;     //m*n
    private static char[][] map;
    private static int[][][] dist;        //记录时间：人和火焰
    private static boolean[][][] vis;     //访问数组
    private static int res=Integer.MAX_VALUE;
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        m=in.nextInt();
        n=in.nextInt();
        in.nextLine();
        map=new char[m][n];
        dist=new int[m][n][2];
        vis=new boolean[m][n][2];
        LinkedList<Node> pQueue=new LinkedList<>();
        LinkedList<Node> fQueue=new LinkedList<>();
        for(int i=0;i<m;i++) {
            map[i]=in.nextLine().toCharArray();
            for(int j=0;j<n;j++) {
                if (map[i][j] == 'J') {           //人
                    vis[i][j][0]=true;
                    dist[i][j][0]=0;
                    pQueue.offer(new Node(i,j));
                } else if (map[i][j] == 'F') {    //着火点
                    vis[i][j][1]=true;
                    dist[i][j][1]=0;
                    fQueue.offer(new Node(i,j));
                }
            }
        }

        //对人和火焰分别做bfs
        bfs(pQueue,0);
        bfs(fQueue,1);
        //对边缘判断
        for(int i=0;i<m;i++){
            check(i,0);
            check(i,n-1);
        }
        for(int i=0;i<n;i++) {
            check(0,i);
            check(m-1,i);
        }

        System.out.println(res);

    }

    private static void check(int x, int y) {
        if (vis[x][y][0]) {         //火焰不能到达||火焰后达到
            if(!vis[x][y][1]||dist[x][y][0]<dist[x][y][1])
                res=Math.min(res,dist[x][y][0]+1);      //+1即走出边界
        }
    }

    private static void bfs(LinkedList<Node> queue, int type) {
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for (int[] d : dir) {
                int x=node.x+d[0],y=node.y+d[1];
                if(x<0||x==m||y<0||y==n||map[x][y]=='#'||vis[x][y][type])  continue;
                vis[x][y][type]=true;
                dist[x][y][type]=dist[node.x][node.y][type]+1;
                queue.offer(new Node(x,y));
            }
        }
    }

    private static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /*
    4 4
####
#JF#
#..#
#..#
     */
}
