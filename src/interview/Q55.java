package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description: 求二叉树的深度
 */
public class Q55 {
    public static void main(String[] args) {

    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别计算左右子树的深度
        int leftCount = depth(root.left);
        int rightCount = depth(root.right);
        // 取深度较大值，再加上当前结点 +1
        return 1 + Math.max(leftCount, rightCount);
    }
}
