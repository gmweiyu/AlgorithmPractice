package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017-05-22.
 */
public class POJ_3984 {
    private static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private static int m,n;
    private static int[][] map;
    private static boolean[][] vis;
    private static int[][] book;
    private static int res=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        m=in.nextInt();n=in.nextInt();
        map=new int[m][n];
        book=new int[m][n];
        vis=new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                map[i][j]=in.nextInt();
            }
        }

//        System.out.println(bfs());
        Stack<Node> stack=new Stack<>();
        Node node=bfs();
        while (node != null) {
            stack.push(node);
            node=node.last;
        }
        while (!stack.isEmpty()) {
            Node cur=stack.pop();
            System.out.println(cur.x + "," + cur.y);
        }
        System.out.println((m-1)+","+(n-1));
    }

    private static Node bfs(){
        vis[0][0]=true;
        book[0][0]=0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(0, 0,null));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for (int[] d : dir) {
                int x=node.x+d[0],y=node.y+d[1];
                if(x<0||x>=m||y<0||y>=n||vis[x][y]||map[x][y]==1) continue;
                vis[x][y]=true;
                book[x][y]=book[node.x][node.y]+1;
                queue.offer(new Node(x,y,node));
                if (x == m - 1 && y == n - 1) {
//                    return book[x][y];
                    return node;
                }
            }
        }
        return null;
    }

    private static class Node{
        int x,y;
        Node last;
        public Node(int x, int y,Node last) {
            this.x = x;
            this.y = y;
            this.last=last;
        }
    }
}
