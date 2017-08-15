package leetcode;

import util.TreeNode;

import java.util.HashMap;

/**
 * Created by GuoWeiyu on 2017/08/11.
 * Description: 根据二叉树的inorder/postorder构建二叉树
 */
public class Q106_ConstructBinaryTree2 {
    public static void main(String[] args) {
        int[] inorder={2,6,9,4,7,1,5,8,3};
        int[] postorder={9,6,7,4,2,8,5,3,1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        // 提前按照value-index存储inorder的index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return internalBuild(inorder, postorder, map, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode internalBuild(int[] inorder, int[] postorder, HashMap<Integer,Integer> map, int indexPost, int startIn, int endIn) {
        if (startIn > endIn) {
            return null;
        }
        // 创建当前子树的root
        int value = postorder[indexPost];
        TreeNode node = new TreeNode(value);
        int indexIn=map.get(value);
        int rightCount=endIn-indexIn;
        node.right = internalBuild(inorder, postorder, map, indexPost - 1, indexIn + 1, endIn);
        node.left = internalBuild(inorder, postorder, map, indexPost - rightCount - 1, startIn, indexIn - 1);
        return node;
    }
}
