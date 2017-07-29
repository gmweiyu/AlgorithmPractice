package OJ.BFS;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017-05-22.
 */
public class POJ_1606 {
    private static int A,B,C;
    private static int[][] book;
    private static boolean[][] vis;
    private static String[] operations={"Empty A","Empty B","Fill A","Fill B","A to B","B to A","Initial"};
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        A=in.nextInt();B=in.nextInt();C=in.nextInt();
        book=new int[A+1][B+1];vis=new boolean[A+1][B+1];
        Node node=bfs();
        Stack<Node> stack=new Stack<>();
        while (node != null) {
            stack.push(node);
            node= node.prev;
        }
        while (!stack.isEmpty()) {
            Node n=stack.pop();
            System.out.println(operations[n.type]);
        }
    }

    private static Node bfs(){
        book[0][0]=0;
        vis[0][0]=true;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(0,0,6,null));
        while (!queue.isEmpty()) {
            Node node=queue.poll();
            for(int i=0;i<6;i++) {      //6种操作
                int a=0,b=0;
                if (i == 0) {                   //空A
                    a=0;
                    b= node.b;
                } else if (i == 1) {            //空B
                    a= node.a;
                    b=0;
                } else if (i == 2) {            //满A
                    a=A;
                    b=node.b;
                } else if (i == 3) {            //满B
                    a= node.a;
                    b=B;
                } else if (i == 4) {            //A->B
                    int all=node.a+node.b;
                    a=all>B?all-B:0;
                    b=all>B?B:all;
                } else if (i == 5) {            //B->A
                    int all=node.a+ node.b;
                    a=all>A?A:all;
                    b=all>A?all-A:0;
                }
                if(vis[a][b])   continue;
                if (b == C) {
                    return new Node(a,b,i,node);
                }
                vis[a][b]=true;
                book[a][b]=book[node.a][node.b]+1;
                queue.offer(new Node(a,b,i,node));
            }
        }
        return null;
    }

    private static class Node{
        int a,b;
        int type;       //操作类型
        Node prev;

        public Node(int a, int b, int type, Node prev) {
            this.a = a;
            this.b = b;
            this.type = type;
            this.prev = prev;
        }
    }
    /*
    3 5 4
5 7 3
     */
}
