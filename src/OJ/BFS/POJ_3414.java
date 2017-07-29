package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-21.
 * http://blog.csdn.net/u013480600/article/details/25241777
 */
public class POJ_3414 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int vA=in.nextInt(),vB=in.nextInt(),c=in.nextInt();
        int[][] dist=new int[vA+1][vB+1];
        boolean[][] vis=new boolean[vA+1][vB+1];
        LinkedList<Node> queue=new LinkedList<>();
        dist[0][0]=0;
        vis[0][0]=true;
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            int a=node.a,b=node.b;
            for(int i=0;i<6;i++) {      //对应3*2种操作
                int na=0,nb=0;
                if (i == 0) {
                    na=0;nb=b;
                } else if (i == 1) {
                    na=a;nb=0;
                }else if (i == 2) {
                    na=vA;nb=b;
                } else if (i == 3) {
                    na=a;nb=vB;
                } else if (i == 4) {        //A->B
                    int all=a+b;
                    na=all>=vB?all-vB:0;
                    nb=all>=vB?vB:all;
                } else if (i == 5) {        //B->A
                    int all=a+b;
                    na=all>=vA?vA:all;
                    nb=all>=vA?all-vA:0;
                }
//                if(dist[a][b]!=0&&node.dist+1>dist[a][b]) continue;
                if(vis[na][nb])   continue;     //已经访问过，即存在此种情况
                vis[na][nb]=true;
                dist[na][nb]=dist[a][b]+1;
                if (na == c || nb == c) {
                    System.out.println(dist[na][nb]);
                    return;
                }
                queue.offer(new Node(na, nb));
            }
        }
    }

    private static class Node{
        int a,b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
