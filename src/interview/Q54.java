package interview;

import util.TreeNode;

/**
 * Created by GuoWeiyu on 2017/08/08.
 * Description: 二叉搜索树中第k大的结点
 */
public class Q54 {
    public static void main(String[] args) {

    }

    /* 维护全局标识，是否已经找到第k大的结点 */
    private static boolean hasFound=false;

    private static int ans;
    private static void findKth(TreeNode node,int index,int k) {
        if (hasFound || node == null) {
            return;
        }

        if (index == k) {
            ans=node.val;
            hasFound=true;
            return;
        }

        if (node.left != null) {
            findKth(node.left,++index,k);
        }
        if (++index == k) {
            ans=node.val;
        }
        if (node.right != null) {
            findKth(node.right, ++index, k);
        }
    }
}
