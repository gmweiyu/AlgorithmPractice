package interview;

import toolkit.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/08/02.
 * Description: 二叉树中和为某一值的路径
 */
public class Q34 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generate("8462351");
        int target=15;
        searchPaths(root, target);
    }

    private static void searchPaths(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        int sum=node.val;
        List<Integer> path=new ArrayList<>();
        path.add(node.val);
        searchPaths(node, sum, target, path);
    }

    private static void searchPaths(TreeNode node, int sum,int target, List<Integer> path) {
        // 剪枝
        if (sum >= target) {
            if (sum == target) {
                System.out.println(path);
            }
            return;
        }
        // 对左右子树进行DFS
        if (node.left != null) {
            internalDfs(node.left,sum,target,path);
        }
        if (node.right != null) {
            internalDfs(node.right,sum,target,path);
        }
    }

    private static void internalDfs(TreeNode node, int sum, int target, List<Integer> path) {
        sum+=node.val;
        path.add(node.val);
        searchPaths(node,sum,target,path);
        sum-=node.val;
        path.remove(path.size() - 1);
    }
}
