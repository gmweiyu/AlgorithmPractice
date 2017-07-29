package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Weasley on 2017-04-07.
 */
public class Q94_BinaryTreeInorder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(2);
        root.left=two;
        root.right=three;
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)  return ans;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node=stack.pop();
            if(node.right!=null){
                stack.push(node.right);
                node.right=null;    //置为空，防止后续重复入栈
            }
            if(node.left==null){
                ans.add(node.val);
                node=null;
            }else{
                stack.push(node);
                stack.push(node.left);
                node.left=null;     //置为空，否则无限循环
            }
        }
        return ans;
    }

    //简洁写法
    public List<Integer> inorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null || !stack.isEmpty())
        {
            if(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
