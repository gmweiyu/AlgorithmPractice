package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/07/24.
 * Description: 根据先序、中序重建二叉树
 */
public class Q7 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 6, 9, 7, 3, 5, 8};
        int[] inorder = {2, 6, 9, 4, 7, 1, 5, 8, 3};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
        TreeNode.printTreeNode(root);
    }

    /**
     * 构建二叉树
     * @return 二叉树的root结点
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return internalBuild(preorder, inorder, 0, 0, preorder.length-1);
    }

    /**
     * 实际的构建函数，递归构造左右子树
     * @param preorder  先序
     * @param inorder   中序
     * @param indexPre  当前子树的root结点在preorder中的index
     * @param startIn   当前子树的root结点在inorder中的起始index
     * @param endIn     当前子树的root结点在inorder中的结束index
     * @return  当前子树的root结点
     */
    private static TreeNode internalBuild(int[] preorder, int[] inorder, int indexPre, int startIn, int endIn) {
        // 退出条件
        if (startIn > endIn) {
            return null;
        }
        // 根据indexPre对应的值构建当前node
        int value = preorder[indexPre];
        TreeNode node = new TreeNode(value);
        // 当前结点在中序的位置
        int indexIn = findPosition(value, inorder);
        // 计算左子树的结点数，以此推出右结点在pre中的位置
        int leftCount = indexIn - startIn;
        // 递归构建二叉树
        node.left = internalBuild(preorder, inorder, indexPre + 1, startIn, indexIn - 1);
        node.right = internalBuild(preorder, inorder, indexPre + leftCount + 1, indexIn + 1, endIn);
        return node;
    }

    /**
     * 找到一个结点在中序中的位置
     * ！可考虑使用HashMap提前存储对应位置，避免每次都使用线性时间查找
     * {@link leetcode.Q106_ConstructBinaryTree2#buildTree(int[], int[])}
     */
    private static int findPosition(int target, int[] inorder) {
        int index=0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                index=i;
                break;
            }
        }
        return index;
    }

}
