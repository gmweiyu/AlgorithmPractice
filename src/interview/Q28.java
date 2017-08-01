package interview;

import toolkit.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 判断二叉树是否对称（镜像操作后与原二叉树相同）
 */
public class Q28 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("8665775");
        System.out.println(isSymmetric(root, root));
    }

    /**
     * 递归判断是否对称：前序序列--镜像前序序列
     */
    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetric(node1.left, node2.right)
                && isSymmetric(node1.right, node2.left);
    }
}
