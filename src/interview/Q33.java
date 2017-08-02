package interview;

/**
 * Created by GuoWeiyu on 2017/08/02.
 * Description: 二叉搜索树的后续遍历序列（因BST不存在重复元素，所以假设输入的序列也不存在重复元素）
 */
public class Q33 {
    public static void main(String[] args) {
//        int[] order = {5, 7, 6, 9, 11, 10, 8};
//        int[] order = {7, 4, 6, 5};
        int[] order = {4, 3, 2, 6, 8, 10, 9, 7, 5};
        System.out.println(match(order,0,order.length-1));
    }

    /**
     * 判断当前区间[start,end]以order[end]为root的二叉树是否能构成BST
     * @param order 二叉树的后续遍历序列
     * @param start
     * @param end   order[root]即为root结点
     * @return  是否能够构成BST
     */
    private static boolean match(int[] order, int start, int end) {
        if (order == null) {
            return false;
        }
        // 当结点树小于等于3时，肯定存在对应的BST
        if (end - start < 3) {
            return true;
        }

        // 从左向右遍历，直到找到一个元素 > root元素，即找到了BST的分界点
        int targetIndex=end;
        for (int i = start; i <end ; i++) {
            if (order[i] > order[end]) {
                targetIndex=i;
                break;
            }
        }

        // 如果满足条件，[targetIndex,end)的元素均应大于order[end]
        for (int i = targetIndex; i <end ; i++) {
            // 出现了非法情况，则说明不存在BST
            if (order[i] < order[end]) {
                return false;
            }
        }

        return match(order, start, targetIndex - 1)
                && match(order, targetIndex, end - 1);
    }

}
