package interview;

/**
 * Created by GuoWeiyu on 2017/07/24.
 * Description: 二叉树的下一个结点（中序）
 */
public class Q8 {
    public static void main(String[] args) {

    }

    private static TreeNode findNext(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 如果当前结点有右子树，则目标结点为右子树最左边的结点
        if (node.right != null) {
            TreeNode leftmost = node.right;
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            return leftmost;
        }
        // 如果当前结点没有右子树：1、结点为父结点的左儿子；2、结点为父结点的右儿子
        else if (node.parent != null) {
            TreeNode current=node;
            TreeNode parent=node.parent;
            while (parent != null && current == parent.right) {
                current=parent;
                parent=current.parent;
            }
            return parent;
        }
        // 当前结点为root，且只有root
        else {
            return null;
        }
    }

    private static class TreeNode{
        int value;
        TreeNode left,right;
        TreeNode parent;    //指向父结点
    }
}
