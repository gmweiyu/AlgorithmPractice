package interview;

import util.DeListNode;
import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/02.
 * Description: 二叉搜索树与双向链表
 */
public class Q36 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("6483579");

        // 第一种方法
        convert(root);

        // 第二种方法
        DeListNode head=myConvert(root);
        System.out.println(head);


    }

    /**
     * 根据树的中序遍历，即可生成对应的双向链表
     * 注意：不需要另外创建双向链表，直接使用二叉树的left/right指代双向链表的prev/next
     */
    // 保存当前遍历的最大（右）结点，不断更新并链接整个Tree
    private static TreeNode lastNode;

    private static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        internalConvert(root);
        
        // 当前lastNode指向的是最后一个结点
        while (lastNode.left != null) {
            lastNode = lastNode.left;
        }

        System.out.println(lastNode);
    }

    private static void internalConvert(TreeNode node) {
        if (node == null) {
            return;
        }

        // 递归处理左子树
        if (node.left != null) {
            internalConvert(node.left);
        }

        // 双向链接当前结点
        node.left = lastNode;
        if (lastNode != null) {
            lastNode.right=node;
        }

        // 链接后更新当前最大结点
        lastNode = node;

        // 递归处理右子树
        if (node.right != null) {
            internalConvert(node.right);
        }
    }



    private static DeListNode myConvert(TreeNode root) {
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
}
