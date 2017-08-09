package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description: 判断二叉树是否为平衡二叉树：每个结点其左右子树高度差不超过1
 * 先序遍历，包含重复子问题，效率较低
 * 后续遍历，先计算子问题，再判断根结点
 */
public class Q55_2 {
    public static void main(String[] args) {

    }

    private static boolean isBalanced(TreeNode root) {
        return internalIsBalanced(root, new int[0]);
    }

    private static boolean internalIsBalanced(TreeNode root, int[] count) {
        if (root == null) {
            count[0] = 0;
            return true;
        }
        // 以数组的形式替换指针
        int[] leftCount = new int[1];
        int[] rightCount = new int[1];
        if (internalIsBalanced(root.left, leftCount) && internalIsBalanced(root.right, rightCount)) {
            if (Math.abs(leftCount[0] - rightCount[0]) <= 1) {
                count[0] = 1 + Math.max(leftCount[0], rightCount[0]);
                return true;
            }
        }
        return false;
    }

}
