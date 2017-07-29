package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-22.
 */
public class POJ_1753 {
    private static int n=4;
    private static char[][] map=new char[4][4];
    private static int[] book=new int[1<<16];        //1<<16个01状态
    private static boolean[] vis=new boolean[1<<16];
    private static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private static int src;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        src=0;
        for (int i=0;i<4;i++) {
            map[i]=in.nextLine().toCharArray();
            for(int j=0;j<4;j++) {
                if (map[i][j] == 'b') {
                    src|=1<<(i*4+j);    //计算初始状态
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs(){
        vis[src]=true;
        book[src]=0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(src));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for(int i=0;i<16;i++) {     //每一个格成为变换中心
                int state=node.state|(1<<i);
                for (int[] d : dir) {    //周围四个格子变换
                    int x=i/4+d[0],y=i%4+d[1];
                    if(x<0||x>=4||y<0||y>=4)    continue;
                    state|=1<<(x*4+y);
                }
                if(vis[state])  continue;   //注意不能在dir for循环中判断
                book[state]=book[node.state]+1;
                if(state==0||state==(1<<16)-1){   //需要-1操作转换为全是1状态
                    return book[state];
                }
                vis[state]=true;
                queue.offer(new Node(state));
            }
        }
        return 0;
    }

    private static class Node{
        int state;
        public Node(int state) {
            this.state = state;
        }
    }

    /*
    bwwb
bbwb
bwwb
bwww
     */
}
