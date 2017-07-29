package interview;

/**
 * Created by GuoWeiyu on 2017/07/24.
 * Description: 根据先序、中序重建二叉树
 */
public class Q7 {
    //    static int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//    static int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
    static int[] pre = {1, 2, 4, 6, 9, 7, 3, 5, 8};
    static int[] mid = {2, 6, 9, 4, 7, 1, 5, 8, 3};
    public static void main(String[] args) {
        // invalid input
        if (pre == null || mid == null) {
            return;
        }
        TreeNode dummy = new TreeNode(-1);
        dummy.left = solve(0, 0, 7);
        dummy.right=null;
        System.out.println(dummy.left);
    }

    private static TreeNode solve(int currentPosition,int start, int end) {
        if (start > end) {
            return null;
        }
        // 当前结点（父结点）的值
        int currentValue = pre[currentPosition];
        TreeNode currentNode = new TreeNode(currentValue);
        // 当前结点在中序的位置
        int midPosition = findPosition(currentValue);
        // 计算左子树的结点数，以此推出右结点在pre中的位置
        int leftCount=midPosition-start;
        // 递归重建二叉树
        currentNode.left = solve(currentPosition + 1, start, midPosition - 1);
        currentNode.right = solve(currentPosition + leftCount+1, midPosition + 1, end);
        return currentNode;
    }

    /**
     * 找到一个结点在中序中的位置
     */
    private static int findPosition(int target) {
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static class TreeNode{
        int value;
        TreeNode left,right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
