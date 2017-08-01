package interview;

import toolkit.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 二叉树的镜像
 */
public class Q27 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("1");
        mirror(root);
        TreeNode.printTreeNode(root);
    }

    /**
     * 将给定的二叉树进行镜像旋转
     *
     * @param node 所给二叉树的root结点
     */
    private static void mirror(TreeNode node) {
        if (node == null) {
            return;
        }
        // 如果左右子树均为null，则可以省略交换null这一步骤
        if (node.left == null && node.right == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        // 分别对左右子树进行mirror操作
        mirror(node.left);
        mirror(node.right);
    }
}
