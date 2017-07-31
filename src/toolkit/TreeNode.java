package toolkit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 普通的二叉树结点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /* 标识当前借结点为满二叉树中的null结点（即"."结点） */
    private static final TreeNode nullNode = new TreeNode(-1);

    /**
     * 根据指定的结点values，生成相应的二叉树
     *
     * @param values 结点的values应以完全二叉树的形式指定，如果遇到null结点则以"."替代
     * @return 生成的二叉树root结点
     */
    public static TreeNode generate(String values) {
        if (values == null || values.length() == 0) {
            return null;
        }
        TreeNode root = internalGenerate(1, values.toCharArray());
        return root;
    }

    /**
     * 根据当前结点的value生成对应的node
     */
    private static TreeNode internalGenerate(int index, char[] arr) {
        // 当前index超出arr的长度或者当前value为'.'，则返回null结点
        if (index > arr.length) {
            return null;
        }
        // 返回满二叉树中的null结点
        if (arr[index - 1] == '.') {
            return nullNode;
        }
        TreeNode cur = new TreeNode(arr[index - 1] - '0');
        cur.left = internalGenerate(2 * index, arr);
        cur.right = internalGenerate(index * 2 + 1, arr);
        return cur;
    }

    /**
     * 横向（BFS）打印给定二叉树所有结点的值
     * @param root 二叉树的根结点
     */
    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur == null) {
                continue;
            }
            if (cur == nullNode) {
                System.out.print(".");
            } else {
                System.out.print(cur.val);
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        System.out.println();
    }
}
