package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 从上到下打印二叉树
 */
public class Q32 {
    /**
     * 算法实现{@link TreeNode#printTreeNode(TreeNode)}
     */
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("8605791");
        // 不分层打印
        TreeNode.printTreeNode(root);
        // 分层打印
        TreeNode.printTreeNode(root,true);
    }
}
