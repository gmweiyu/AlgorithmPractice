package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 判断B树是否为A树的子结构
 */
public class Q26 {
    public static void main(String[] args) {
        TreeNode rootA = TreeNode.generate("88792...47");
        TreeNode rootB = TreeNode.generate("892");
        TreeNode.printTreeNode(rootA);
        TreeNode.printTreeNode(rootB);
        System.out.println(match(rootA, rootB));
    }

    private static boolean match(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }

        boolean ans = false;
        if (a.val == b.val) {
            ans = internalMatch(a, b);
        }
        // 递归匹配当前结点的左右子树
        if (!ans) {
            ans = match(a.left, b) || match(a.right, b);
        }
        return ans;
    }

    private static boolean internalMatch(TreeNode a, TreeNode b) {
        // b结点为null，无论a是否为null，始终匹配
        if (b == null) {
            return true;
        }
        // a结点为null，b结点不为null（程序执行到此处已经满足），则不匹配
        if (a == null) {
            return false;
        }
        // 递归判断左右子树是否同时匹配
        if (a.val == b.val) {
            return internalMatch(a.left, b.left) && internalMatch(a.right, b.right);
        } else {
            return false;
        }
    }
}
