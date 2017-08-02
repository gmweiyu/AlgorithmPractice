package interview;

import toolkit.DeListNode;
import toolkit.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/02.
 * Description: 二叉搜索树与双向链表
 */
public class Q36 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("6483579");
        DeListNode head=convert(root);
        System.out.println(head);
    }

    private static DeListNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 根据当前树结点创建对应的双向链表结点
        return solve(root, false);
    }

    /**
     * 根据传入的root结点，生成对应的双向链表
     * @param node
     * @param leftFlag 标记当前树是否为父节点的左子树，用于后续寻找链表最大、小值
     * @return
     */
    private static DeListNode solve(TreeNode node, boolean leftFlag) {
        DeListNode current = new DeListNode(node.val);
        // 当前结点为叶子结点
        if (node.left == null && node.right == null) {
            return current;
        }
        // 递归处理左右子树，并链接为双向链表；注意链接时需要双向链接
        if (node.left != null) {
            current.prev = solve(node.left, true);
            current.prev.next=current;
        }
        if (node.right != null) {
            current.next = solve(node.right, false);
            current.next.prev=current;
        }
        return findTheOutermost(current, leftFlag);
    }

    /**
     * 寻找当前子树（链表）中最大、小的node
     * 当前树为左子树时，需找到其最大（右）的结点
     */
    private static DeListNode findTheOutermost(DeListNode node,boolean lastFlag) {
        if (lastFlag) {
            while (node.next != null) {
                node = node.next;
            }
        } else {
            while (node.prev != null) {
                node=node.prev;
            }
        }
        return node;
    }


    /**
     * 根据树的中序遍历，即可生成对应的双向链表
     */
    private static DeListNode optimizeConvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        return null;
    }

    private static DeListNode internalConvert(TreeNode node, DeListNode deListNode) {
        return null;
    }
}
