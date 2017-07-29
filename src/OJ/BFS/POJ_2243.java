package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-21.
 * http://blog.csdn.net/u013480600/article/details/25426851
 */
public class POJ_2243 {
    private static int[][] dir={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    private static int m,n;
    private static int srcX,srcY,desX,desY;
    private static int[][] book;
    private static boolean[][] vis;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        m=in.nextInt();n=in.nextInt();
        book=new int[m][n];vis=new boolean[m][n];
        srcX=in.nextInt();srcY=in.nextInt();
        desX=in.nextInt();desY=in.nextInt();
        System.out.println(bfs());
    }

    private static int bfs() {
        LinkedList<Node> queue=new LinkedList<>();
        vis[srcX][srcY]=true;
        book[srcX][srcY]=0;
        queue.offer(new Node(srcX, srcY));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for (int[] d : dir) {       //八个方向
                int newX=node.x+d[0],newY=node.y+d[1];
                if(newX<0||newX>=m||newY<0||newY>=n||vis[newX][newY])   continue;
                vis[newX][newY]=true;
                book[newX][newY]=book[node.x][node.y]+1;
                if (newX == desX && newY == desY) {
                    return book[newX][newY];
                }
                queue.offer(new Node(newX, newY));
            }
        }
        return -1;
    }

    private static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
