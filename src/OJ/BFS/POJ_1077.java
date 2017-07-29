package OJ.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by GuoWeiyu on 2017-05-22.
 */
public class POJ_1077 {
    private static int n=3;     //3*3
    private static int[] book=new int[1000003+1];
    private static boolean[] vis=new boolean[1000003+1];
    private static int[] srcOder=new int[9];
    private static int src,target=123456780;        //每一位代表一个数字
    private static int pos;
    private static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};     //u/d/l/r
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index=0;
        for(int i=0;i<9;i++) {
            String s=in.next();
            if (s.equals("x")) {
                srcOder[index++]=0;
            } else {
                srcOder[index++]=Integer.parseInt(s);
            }
        }
        src = hash(srcOder);
        System.out.println(bfs());
    }

    private static int bfs(){
        vis[src]=true;
        book[src]=0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(pos,src,srcOder,null));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for(int i=0;i<4;i++) {
                int x=node.pos/3,y=node.pos%3;
                int newX=x+dir[i][0],newY=y+dir[i][1];
                if(newX<0||newX>=3||newY<0||newY>=3) continue;
                int newPos=newX*3+newY;     //x交换后新的位置
                int[] order= node.order;
                int t=order[pos];       //交换两个数
                order[pos]=order[newPos];
                order[newPos]=t;
                int newState=hash(order);
                if(vis[newState])   continue;
                vis[newState]=true;
                book[newState]=book[node.state]+1;
                if (newState == target) {
                    return book[newState];
                }
                queue.offer(new Node(newPos,newState,order,node));
            }
        }
        return -1;
    }

    private static int hash(int[] order){
        int res=0;
        for(int i=0;i<9;i++) {
            res=res*10+order[i];
        }
        return res&1000003;
    }

    private static class Node{
        int pos;        //x的位置
        int state;
        int[] order;
        Node prev;

        public Node(int pos, int state, int[] order, Node prev) {
            this.pos = pos;
            this.state = state;
            this.order = order;
            this.prev = prev;
        }
    }

}
