package util;

import java.util.*;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 普通的二叉树结点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /* 标识当前借结点为满二叉树中的null结点（即"."结点） */
    private static final TreeNode nullNode = new TreeNode(-1);

    /**
     * 根据指定的结点values，生成相应的二叉树
     *
     * @param values 结点的values应以完全二叉树的形式指定，如果遇到null结点则以"."替代
     * @return 生成的二叉树root结点
     */
    public static TreeNode generate(String values) {
        if (values == null || values.length() == 0) {
            return null;
        }
        TreeNode root = internalGenerate(1, values.toCharArray());
        return root;
    }

    /**
     * 根据当前结点的value生成对应的node
     */
    private static TreeNode internalGenerate(int index, char[] arr) {
        // 当前index超出arr的长度或者当前value为'.'，则返回null结点
        if (index > arr.length) {
            return null;
        }
        // 返回满二叉树中的null结点
        if (arr[index - 1] == '.') {
            return nullNode;
        }
        TreeNode cur = new TreeNode(arr[index - 1] - '0');
        cur.left = internalGenerate(2 * index, arr);
        cur.right = internalGenerate(index * 2 + 1, arr);
        return cur;
    }

    /**
     * 横向打印给定二叉树，默认不分层打印
     *
     * @param root
     */
    public static void printTreeNode(TreeNode root) {
        printTreeNode(root, false);
    }

    /**
     * 横向（BFS）打印给定二叉树所有结点的值
     *
     * @param root      二叉树的根结点
     * @param hierarchy 是否按照树的层级打印
     */
    public static void printTreeNode(TreeNode root, boolean hierarchy) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当前层需要打印的元素个数
        int curCount = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur == nullNode) {
                System.out.print(".");
            } else {
                System.out.print(cur.val);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                if (hierarchy) {
                    nextCount++;
                }
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                if (hierarchy) {
                    nextCount++;
                }
            }
            if (hierarchy) {
                // 当前层待打印数目-1
                curCount--;
                if (curCount == 0) {
                    System.out.println();
                    curCount = nextCount;
                    nextCount = 0;
                }
            }
        }
        System.out.println();
    }

    /**
     * 返回二叉树的先序遍历结果
     * 递归实现：{@link #internalPreOrder(TreeNode, List)}
     * 非递归实现1：{@link #internalPreOrderIteratively(TreeNode, List)}
     * 非递归实现2：{@link #internalPreOrderIteratively_2(TreeNode, List)}
     */
    public static List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        internalPreOrder(root, ans);
        return ans;
    }

    /**
     * 先序遍历：递归实现
     */
    private static void internalPreOrder(TreeNode node, List<Integer> ans) {
        ans.add(node.val);
        if (node.left != null) {
            internalPreOrder(node.left, ans);
        }
        if (node.right != null) {
            internalPreOrder(node.right, ans);
        }
    }

    /**
     * 先序遍历：非递归实现1
     */
    private static void internalPreOrderIteratively(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ans.add(current.val);
            // 先压入右结点，再压入左结点
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 先序遍历：非递归实现2
     */
    private static void internalPreOrderIteratively_2(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 先最大限度向左遍历
            while (current != null) {
                ans.add(current.val);
                stack.push(current);
                current = current.left;
            }
            // 获取栈顶结点的右结点，以同样思想遍历
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    /**
     * 返回二叉树的中序遍历结果
     * 递归实现：{@link #internalInOrder(TreeNode, List)}
     * 非递归实现：{@link #internalInOrderIteratively(TreeNode, List)}
     */
    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        internalInOrder(root, ans);
        return ans;
    }

    /**
     * 中序遍历：递归实现
     */
    private static void internalInOrder(TreeNode node, List<Integer> ans) {
        if (node.left != null) {
            internalInOrder(node.left, ans);
        }
        ans.add(node.val);
        if (node.right != null) {
            internalInOrder(node.right, ans);
        }
    }

    /**
     * 中序遍历：非递归实现
     */
    private static void internalInOrderIteratively(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 最大限度向左遍历，但不访问结点值
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 弹出栈顶结点并访问，再以同样思想遍历右子树
            if (!stack.isEmpty()) {
                current = stack.pop();
                ans.add(current.val);
                current = current.right;
            }
        }
    }

    /**
     * 返回二叉树的后续遍历结果
     * 递归实现：{@link #internalPostOrder(TreeNode, List)}
     * 非递归实现1：{@link #internalPostOrderIteratively(TreeNode, List)}
     * 非递归实现2：{@link #internalPostOrderIteratively_2(TreeNode, List)}
     */
    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        internalPostOrder(root, ans);
        return ans;
    }

    /**
     * 后序遍历递归实现
     */
    private static void internalPostOrder(TreeNode node, List<Integer> ans) {
        if (node.left != null) {
            internalPostOrder(node.left, ans);
        }
        if (node.right != null) {
            internalPostOrder(node.right, ans);
        }
        ans.add(node.val);
    }

    /**
     * 后续遍历：非递归实现
     */
    private static void internalPostOrderIteratively(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisit = null;
        while (!stack.isEmpty()) {
            // 注意：非直接pop，需先判断
            TreeNode current = stack.peek();
            // 如果当前结点为叶子结点||当前结点的子节点均已遍历过
            if ((current.left == null && current.right == null)
                    || lastVisit != null && (current.left == lastVisit || current.right == lastVisit)) {
                ans.add(current.val);
                stack.pop();
                lastVisit = current;
            }
            // 先压入右子树，再压入左子树
            else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    /**
     * 后续遍历：非递归实现2
     */
    private static void internalPostOrderIteratively_2(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode lastVisit=root;
        TreeNode node=root;
        while (node != null || !stack.isEmpty()) {
            // 最大限度向左遍历结点，但不访问
            while (node != null) {
                stack.push(node);
                node= node.left;
            }
            // 查看当前栈顶元素，其左结点为null
            node=stack.peek();
            // 如果栈顶元素的右结点为null||上次访问过
            if (node.right == null || node.right == lastVisit) {
                ans.add(node.val);
                stack.pop();
                lastVisit = node;
                node = null;      //置为null，沿栈向上遍历
            }
            // 以相同的方式遍历右子树
            else {
                node=node.right;
            }
        }
    }
}
