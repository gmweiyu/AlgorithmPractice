package OJ.BFS;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-20.
 * http://blog.csdn.net/u013480600/article/details/26955587
 */
public class HDU_1072 {
    private static int M,N;
    private static int[][] map;             //矩阵
    private static int[][][] book;          //记录x,y,time对应的最少路程
    private static int srcX,srcY,desX,desY;
    private static int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M=in.nextInt();
        N=in.nextInt();
        map=new int[M][N];
        book=new int[M][N][10];
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                map[i][j]=in.nextInt();
                if (map[i][j] == 2) {
                    srcX=i;         //2代表起点
                    srcY=j;
                } else if (map[i][j] == 3) {
                    desX=i;         //3代表终点
                    desY=j;
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs(){
        LinkedList<Node> queue=new LinkedList<>();
        queue.offer(new Node(srcX,srcY,6,0));
        book[srcX][srcY][6]=0;
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for (int[] aDir : dir) {
                int x = node.x + aDir[0], y = node.y + aDir[1];
                if (x < 0 || x == M || y < 0 || y == N || map[x][y] == 0) continue;  //新坐标不合法
                int time = map[x][y] == 4 ? 6 : node.time - 1;
                int dist = node.dist + 1;
                //还未赋值||有更短的路径
                if (book[x][y][time] == 0 || book[x][y][time] > dist) {
                    book[x][y][time]=dist;
                    if (time > 1) queue.offer(new Node(x, y, time, dist));      //bfs添加过程
                    if (x == desX && y == desY) return dist;        //找到最短路径
                }
            }
        }
        return -1;
    }

    private static class Node{
        int x,y;            //坐标
        int time,dist;      //时间、路程

        public Node(int x, int y, int time, int dist) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.dist = dist;
        }
    }
}
