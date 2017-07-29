package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Weasley on 2017-04-07.
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode one=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        one.left=two;
        one.right=three;
        three.left=four;
        three.right=five;
        System.out.println(levelOrder(one));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null) return ans;
        List<Integer> curAns=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        int nextNum=0;      //下一层的结点数目
        int curNum=1;       //当前层还剩余未遍历的结点数
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node=queue.poll();
            curAns.add(node.val);
            curNum--;
            if(node.left!=null) {
                queue.offer(node.left);
                nextNum++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextNum++;
            }
            if(curNum==0){      //当前层遍历完了
                curNum=nextNum;     //进入下一层
                nextNum=0;
                ans.add(curAns);        //添加当前层的结果
                curAns=new ArrayList<>();   //刷新
            }
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
