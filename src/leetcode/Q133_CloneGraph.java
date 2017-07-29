package leetcode;

import java.util.*;

/**
 * Created by Weasley on 2017-04-03.
 */
public class Q133_CloneGraph {
    public static void main(String[] args) {

    }

    //使用BFS克隆图
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();   //原图的点->克隆图的点
        map.put(node,clone);        //复制
        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();    //存储bfs下一遍历点
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur=queue.poll();       //出队列
            for (UndirectedGraphNode n : cur.neighbors) {
                if (!map.containsKey(n)) {
                    clone=new UndirectedGraphNode(n.label);     //复制序号
                    map.put(n,clone);
                    queue.offer(n);     //加入队列，后续遍历
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    //使用DFS：1、非递归---Stack；2、递归

    //图结点
    class UndirectedGraphNode {
        int label;      //点的序号
        List<UndirectedGraphNode> neighbors;        //邻接点
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}