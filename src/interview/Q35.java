package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GuoWeiyu on 2017/08/02.
 * Description: 复杂链表的复制
 */
public class Q35 {
    public static void main(String[] args) {

    }

    /**
     * 使用HashMap来保存sibling属性的正确位置
     * Time complexity: O(N); Space complexity: O(N)
     */
    // 遍历时保存原链表、复制链表中的所有结点的映射关系，在连接sibling时提供参考
    private static Map<ComplexListNode, ComplexListNode> nodesMap = new HashMap<>();

    private static ComplexListNode copy(ComplexListNode node) {
        if (node == null) {
            return null;
        }

        // 复制当前结点
        ComplexListNode current = new ComplexListNode(node.val);
        // 递归处理origin的next结点
        nodesMap.put(node, current);
        current.next = copy(node.next);

        // 非递归处理origin的sibling结点，因为sibling属性不是连续的
        if (node.sibling != null) {
            current.sibling = nodesMap.get(node.sibling);
        }

        return current;
    }


    /**
     * 总体采用三步来完成复杂链表的复制操作
     * 1、复制每一个结点
     * 2、连接sibling结点
     * 3、拆分
     * Time complexity: O(N); Space complexity: O(1)
     *
     * @param node
     * @return
     */
    private static ComplexListNode optimizeCopy(ComplexListNode node) {
        if (node == null) {
            return null;
        }
        copyNodes(node);
        ConnectSiblings(node);
        return divideNodes(node);
    }

    /**
     * 第一步：直接复制每一个结点，并将该结点连接到其sibling结点
     *
     * @param node
     */
    private static void copyNodes(ComplexListNode node) {
        while (node != null) {
            ComplexListNode copiedNode = new ComplexListNode(node.val);
            copiedNode.next=node.next;
            node.next=copiedNode;

            node=copiedNode.next;
        }
    }

    /**
     * 第二步： 连接sibling
     * 根据第一步的结果，node.next即为复制结点。那么node.next.sibling=node.sibling.next;
     *
     * @param node
     */
    private static void ConnectSiblings(ComplexListNode node) {
        while (node != null) {
            ComplexListNode copied=node.next;
            if (node.sibling != null) {
                copied.sibling=node.sibling.next;
            }
            node=copied.next;
        }
    }

    /**
     * 经过前两步操作，链表的结构为：
     * origin -> copy -> origin -> copy -> origin -> copy ...
     * @param node
     * @return
     */
    private static ComplexListNode divideNodes(ComplexListNode node) {
        ComplexListNode dummy = new ComplexListNode(-1);
        ComplexListNode copiedHead = dummy;
        while (node != null) {
            // 如果当前结点索引是偶数，则为复制后的结点
            copiedHead.next = node.next;
            copiedHead=copiedHead.next;

            node = node.next.next;
        }
        return dummy.next;
    }

    private static class ComplexListNode {
        int val;
        ComplexListNode next;
        // 指向邻近（兄弟）结点
        ComplexListNode sibling;

        public ComplexListNode(int val) {
            this.val = val;
        }
    }
}
